/*
 * Copyright 2022-2022 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.linliangjun.commons.codec.core;

import java.util.Objects;

/**
 * 抽象编码器
 *
 * @author linliangjun
 */
public abstract class AbstractCoder<S, T, D extends Detail> implements Coder<S, T, D> {

    public AbstractCoder() {
    }

    @Override
    public final T code(S source, D detail) throws CodeException {
        try {
            source = beforeCode(source, detail);
            T target = doCode(source, detail);
            return afterCode(target, detail);
        } catch (CodeException e) {
            throw e;
        } catch (Exception e) {
            throw new CodeException(e.getLocalizedMessage());
        }
    }

    protected S beforeCode(S source, D detail) {
        Objects.requireNonNull(detail, "清单不能为 null");
        return source;
    }

    protected abstract T doCode(S source, D detail) throws CodeException;

    protected T afterCode(T target, D detail) {
        return target;
    }
}
