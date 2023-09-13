package com.security.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TbPushDetail)实体类
 *
 * @author 
 * @since 2023-03-18 21:25:33
 */
public class TbPushDetail implements Serializable {
    private static final long serialVersionUID = 544843607183249110L;
    /**
     * 序号
     */
    private Long id;
    /**
     * 推送id
     */
    private Long pushId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 线路id
     */
    private Long routeId;
    /**
     * 站点id
     */
    private Long siteId;
    /**
     * 学生id
     */
    private Long passengerId;
    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 线路名称
     */
    private String routeName;
    /**
     * 站点
     */
    private String siteName;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 年级
     */
    private String grade;
    /**
     * 学生姓名
     */
    private String passengerName;
    /**
     * 金额
     */
    private Double money;
    /**
     * 套餐名称
     */
    private String packageName;
    /**
     * 家长姓名
     */
    private String customerName;
    /**
     * 支付状态：1、待支付，2、已支付，3、已取消
     */
    private String state;
    /**
     * 推送时间
     */
    private Date pushTime;
    /**
     * 订单号
     */
    private String outTradeNo;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 家长联系电话
     */
    private String phone;
    /**
     * 推送状态:0、未重新推送，1，已重新推送
     */
    private String pushState;
    /**
     * 套餐费是否包含卡押金：0代表不包含，1代表包含
     */
    private String cashPledgeInclude;
    /**
     * 套餐费是否包含刷脸刷卡服务费：0代表不包含，1代表包含
     */
    private String serverCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPushId() {
        return pushId;
    }

    public void setPushId(Long pushId) {
        this.pushId = pushId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPushState() {
        return pushState;
    }

    public void setPushState(String pushState) {
        this.pushState = pushState;
    }

    public String getCashPledgeInclude() {
        return cashPledgeInclude;
    }

    public void setCashPledgeInclude(String cashPledgeInclude) {
        this.cashPledgeInclude = cashPledgeInclude;
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

}

