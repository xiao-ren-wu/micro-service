package org.yuwb.store;

import java.time.LocalDateTime;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/30 7:43 上午
 * @since java 11
 */
public interface StoreServiceApi {
    /**
     * 查看版本号
     *
     * @param supplierId
     * @param goodsId
     * @return
     */
    int selectVersion(String supplierId, String goodsId);

    /**
     * 乐观锁
     *
     * @param version
     * @param goodsId
     * @param updateBy
     * @param updateTime
     * @return
     */
    int updateStoreCountByVersion(int version,String supplierId, String goodsId, String updateBy, LocalDateTime updateTime);

    /**
     * 查询剩余库存
     *
     * @param supplierId
     * @param goodsId
     * @return
     */
    int selectStoreCount(String supplierId, String goodsId);
}
