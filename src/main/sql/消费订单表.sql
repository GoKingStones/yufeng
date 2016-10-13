DROP TABLE if EXISTS consumer_order_table;
CREATE TABLE `consumer_order_table` (

  user_internal_code varchar(50) NOT NULL COMMENT '购买用户内码',
  seller_internal_code  varchar(50) NOT NULL COMMENT '商户内码',
  loanAcctNo	VARCHAR(13) NOT NULL COMMENT '中银消费金融账号',
  merchantCode VARCHAR(15) NOT NULL COMMENT '清算機構商户代号',
  payAmount	DECIMAL(8,2) NOT NULL COMMENT '消費金額',
  merchantOrderId VARCHAR(32) NOT NULL COMMENT '消費交易訂单号',
  payGateOrderId	VARCHAR(32) NOT NULL COMMENT '中银消費(動用)交易订单号码',
  payType	VARCHAR(1) NOT NULL COMMENT '消费支付类型',
  chargeType	VARCHAR(1) NOT NULL COMMENT '账户充值类型',
  currency	VARCHAR(3) NOT NULL COMMENT '币种',
  useTempCreLine	VARCHAR(1) NOT NULL COMMENT '是否同意加额',
  payDescription	VARCHAR(100) NOT NULL COMMENT '订单备注说明',
  instalPeriod	VARCHAR(3) NOT NULL COMMENT '分期期数',
  instalType	VARCHAR(1) NOT NULL COMMENT '分期方案',
  instalFeeType VARCHAR(1) NOT NULL COMMENT '分期手续费方案',
  returnAmt	DECIMAL(8,2)  COMMENT '撤銷金額',
  merchantOrderId	VARCHAR(32)  COMMENT '撤銷交易订单号码',
  payGateOrderId	VARCHAR(32)  COMMENT '中银撤銷交易订单号码',
  returnAmt	DECIMAL(8,2)  COMMENT '退货金额',
  merchantOrderId VARCHAR(32) COMMENT '退貨交易订单号码',
  payGateOrderId	VARCHAR(32) COMMENT '中银退货交易订单号码',
  orderState VARCHAR(1) NOT NULL COMMENT '订单当前状态',
  transType VARCHAR(2) NOT NULL COMMENT '交易类别',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `mod_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户额度信息表';