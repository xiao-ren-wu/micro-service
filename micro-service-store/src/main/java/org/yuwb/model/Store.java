package org.yuwb.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuwb
 * @since 2019-12-26
 */
@Data
@Accessors(chain = true)
@TableName("t_store")
public class Store {

    private static final long serialVersionUID=1L;

    private String storeId;

    private String goodsId;

    private String supplierId;

    private String goodsName;

    private Integer storeCount;

    private Integer version;

    private String createBy;

    private LocalDateTime createTime;

    private String updateBy;

    private LocalDateTime updateTime;


}
