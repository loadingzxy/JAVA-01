CREATE TABLE `tb_item`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id，同时也是商品编号',
    `gmt_create`     datetime       NOT NULL COMMENT '创建时间',
    `gmt_modify`     datetime       NOT NULL COMMENT '更新时间',
    `title`          varchar(100)   NOT NULL COMMENT '商品标题',
    `sell_point`     varchar(500)   DEFAULT NULL COMMENT '商品卖点',
    `price`          decimal(20, 2) NOT NULL COMMENT '商品价格，单位为：元',
    `stock_count`    int(10) DEFAULT NULL,
    `num`            int(10) NOT NULL COMMENT '库存数量',
    `barcode`        varchar(30)    DEFAULT NULL COMMENT '商品条形码',
    `image`          varchar(2000)  DEFAULT NULL COMMENT '商品图片',
    `categoryId`     bigint(10) NOT NULL COMMENT '所属类目，叶子类目',
    `status`         varchar(1)     NOT NULL COMMENT '商品状态，1-正常，2-下架，3-删除',
    PRIMARY KEY (`id`),
    KEY              `cid` (`categoryId`),
    KEY              `status` (`status`),
    KEY              `updated` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='商品表';