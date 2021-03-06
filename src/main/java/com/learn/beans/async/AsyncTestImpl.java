package com.learn.beans.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

/**
 * @author: luzhiqing
 * @date: 2021-02-06
 **/
@Service
public class AsyncTestImpl implements AsyncTest {
    @Autowired
    private AsyncTestDp asyncTestDp;

    @Override
    public void trigger1() {
        this.trigger();
    }

    @Override
    @Async
    @Transactional
    public Future<Boolean> trigger() {
        return new AsyncResult<>(true);
    }
}
