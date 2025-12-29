package com.transactionsystem.transactionsystem.processor;

import com.transactionsystem.transactionsystem.entity.Account;
import com.transactionsystem.transactionsystem.entity.Transaction;
import com.transactionsystem.transactionsystem.repository.AccountRepo;
import com.transactionsystem.transactionsystem.repository.TransactionRepo;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionItemProcessor implements ItemProcessor<Transaction, Transaction> {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    @Override
    public Transaction process(Transaction tx) {

        if (transactionRepo.existsById(tx.getTransactionId())) {
            return null; // already processed
        }

        Account account = accountRepo.findById(tx.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (!"ACTIVE".equalsIgnoreCase(account.getStatus())) {
            return null;
        }

        if ("DEBIT".equalsIgnoreCase(tx.getTransactionType())) {
            if (account.getBalance() < tx.getAmount()) {
                return null; // skip if insufficient balance
            }
            account.setBalance(account.getBalance() - tx.getAmount());
        } else if ("CREDIT".equalsIgnoreCase(tx.getTransactionType())) {
            account.setBalance(account.getBalance() + tx.getAmount());
        }
        tx.setTransactionDate(LocalDate.now());


        tx.setAccount(account);

        accountRepo.save(account);

        return tx;
    }
}
