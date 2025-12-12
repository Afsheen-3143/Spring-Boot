package com.batchprocessing.user.config;

import com.batchprocessing.user.entity.User;
import com.batchprocessing.user.processor.UserItemProcessor;
import com.batchprocessing.user.repository.UserRepo;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public FlatFileItemReader<User> reader() {
        FlatFileItemReader<User> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("users.csv"));
//        reader.setLinesToSkip(1); // Skip header

        DefaultLineMapper<User> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("id", "name", "email");

        BeanWrapperFieldSetMapper<User> mapper = new BeanWrapperFieldSetMapper<>();
        mapper.setTargetType(User.class);

        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(mapper);

        reader.setLineMapper(lineMapper);

        return reader;
    }

    @Bean
    public UserItemProcessor processor() {
        return new UserItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<User> writer(UserRepo repo) {
        RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
        writer.setRepository(repo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemReader<User> reader,
            UserItemProcessor processor,
            RepositoryItemWriter<User> writer
    ) {
        return new StepBuilder("csv-step", jobRepository)
                .<User, User>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step1) {
        return new JobBuilder("csv-job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }
}
