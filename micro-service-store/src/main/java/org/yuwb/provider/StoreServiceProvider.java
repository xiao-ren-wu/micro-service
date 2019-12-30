package org.yuwb.provider;

import org.apache.dubbo.config.annotation.Service;
import org.yuwb.dao.StoreMapper;
import org.yuwb.store.StoreServiceApi;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author WbYu
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * <p>
 * </p>
 * @version v1.0.0
 * @date 2019/12/30 7:46 上午
 * @since java 11
 */
@Service(version = "1.0.0")
public class StoreServiceProvider implements StoreServiceApi {

    @Resource
    private StoreMapper storeMapper;

    @Override
    public int selectVersion(String supplierId, String goodsId) {
        return storeMapper.selectVersion(supplierId,goodsId);
    }

    @Override
    public int updateStoreCountByVersion(int version,String supplierId, String goodsId, String updateBy, LocalDateTime updateTime) {
        return storeMapper.updateStoreCountByVersion(version,supplierId, goodsId, updateBy, updateTime);
    }

    @Override
    public int selectStoreCount(String supplierId, String goodsId) {
        return storeMapper.selectStoreCount(supplierId,goodsId);
    }
}
