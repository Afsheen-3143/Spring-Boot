package com.transactionsystem.transactionsystem.config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.transactionsystem.transactionsystem.entity.Transaction;
import com.transactionsystem.transactionsystem.processor.TransactionItemProcessor;
import com.transactionsystem.transactionsystem.repository.TransactionRepo;

@Configuration

public class BatchConfig {

    @Bean
    public FlatFileItemReader<Transaction> reader() {
        FlatFileItemReader<Transaction> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("transactions.csv"));
        reader.setLinesToSkip(1); // skip header

        DefaultLineMapper<Transaction> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(",");
        tokenizer.setNames("transactionId","accountId","transactionType","amount");

        BeanWrapperFieldSetMapper<Transaction> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Transaction.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        reader.setLineMapper(lineMapper);

        return reader;
    }

    @Bean
    public TransactionItemProcessor processor() {
        return new TransactionItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<Transaction> writer(TransactionRepo repo) {
        RepositoryItemWriter<Transaction> writer = new RepositoryItemWriter<>();
        writer.setRepository(repo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      FlatFileItemReader<Transaction> reader,
                      TransactionItemProcessor processor,
                      RepositoryItemWriter<Transaction> writer) {

        return new StepBuilder("transaction-step", jobRepository)
                .<Transaction, Transaction>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job transactionJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("transaction-job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
}
