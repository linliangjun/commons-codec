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

/**
 * 抽象字节数组明细
 *
 * @author linliangjun
 */
public abstract class AbstractBytesDetail implements Detail {

    private static final BytesOrder DEFAULT_BYTES_ORDER = BytesOrder.BIG_ENDIAN;

    /**
     * 字节数组长度，必须大于 0
     */
    private int length;

    /**
     * 字节序，默认为 {@linkplain BytesOrder#BIG_ENDIAN}
     */
    private BytesOrder order = DEFAULT_BYTES_ORDER;

    /**
     * 是否填充 0，默认开启（编码后的目标字节数组长度若小于期望长度，开启此项会填充 0 直至补齐）
     */
    private boolean zeroFill = true;

    public AbstractBytesDetail() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BytesOrder getOrder() {
        return order;
    }

    public void setOrder(BytesOrder order) {
        this.order = order;
    }

    public boolean isZeroFill() {
        return zeroFill;
    }

    public void setZeroFill(boolean zeroFill) {
        this.zeroFill = zeroFill;
    }
}
