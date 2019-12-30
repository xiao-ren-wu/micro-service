package org.yuwb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.yuwb.model.Store;

import java.time.LocalDateTime;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/26 8:38 上午
 * @since java 11
 */
public interface StoreMapper extends BaseMapper<Store> {

    int selectVersion(String supplierId, String goodsId);


    int updateStoreCountByVersion(int version,String supplierId, String goodsId, String updateBy, LocalDateTime updateTime);


    int selectStoreCount(String supplierId, String goodsId);
}
