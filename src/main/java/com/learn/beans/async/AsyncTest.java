package com.learn.beans.async;

import java.util.concurrent.Future;

public interface AsyncTest {
    void trigger1();
    Future<Boolean> trigger();
}
