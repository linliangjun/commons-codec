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

package cn.linliangjun.commons.codec.core.util;

/**
 * 字节数组工具类
 *
 * @author linliangjun
 */
public final class BytesUtils {

    private BytesUtils() {
    }

    /**
     * 反转字节数组
     */
    public static void reverse(byte[] bytes) {
        int len = bytes.length, mid = len / 2;
        for (int i = 0; i < mid; i++) {
            swap(bytes, i, len - i - 1);
        }
    }

    /**
     * 填充 0
     *
     * @param srcBytes 源字节数组
     * @param count    填充的数量
     * @return 填充 0 后的字节数组
     */
    public static byte[] zerofill(byte[] srcBytes, int count) {
        var srcLen = srcBytes.length;
        var target = new byte[srcLen + count];
        System.arraycopy(srcBytes, 0, target, 0, srcLen);
        return target;
    }

    private static void swap(byte[] bytes, int i, int j) {
        var tmp = bytes[i];
        bytes[i] = bytes[j];
        bytes[j] = tmp;
    }
}
