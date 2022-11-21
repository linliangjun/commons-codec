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

import cn.linliangjun.commons.codec.core.util.BytesUtils;

import java.util.Objects;

/**
 * 抽象字节数组编码器
 *
 * @author linliangjun
 */
public abstract class AbstractBytesCoder<S, D extends AbstractBytesDetail> extends AbstractCoder<S, byte[], D> {

    public AbstractBytesCoder() {
    }

    @Override
    protected S beforeCode(S source, D detail) {
        source = super.beforeCode(source, detail);
        Objects.requireNonNull(source, "源对象不能为 null");
        return source;
    }

    @Override
    protected byte[] afterCode(byte[] target, D detail) {
        Objects.requireNonNull(target, "目标字节数组不能为 null");
        int expectLen = detail.getLength(), actualLen = target.length, gap = expectLen - actualLen;
        if (gap < 0) {
            throw new CodeException("目标字节数组实际长度大于期望长度：%d > %d".formatted(actualLen, expectLen));
        }
        if (gap > 0) {
            if (!detail.isZeroFill()) {
                throw new CodeException("目标字节数组实际长度小于期望长度：%d < %d".formatted(actualLen, expectLen));
            }
            target = BytesUtils.zerofill(target, gap);
        }
        if (detail.getOrder() == BytesOrder.LITTLE_ENDIAN) {
            BytesUtils.reverse(target);
        }
        return target;
    }
}
