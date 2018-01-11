package com.gaoyu.restbean;

import java.util.Date;

/**
 * 
 * ClassName: CarrierRestBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年12月31日 上午11:41:56 <br/>
 *
 * @author gaoyu
 * @version 
 * @since JDK 1.7
 */
public class CarrierRestBean
{
    private String carrierName;
    
    private String carrierCode;
    
    private String factoryName;
    
    private String factoryCode;
    
    private String companyQualification;
    
    private String registeredMoney;
    
    private int vehicleNum;
    
    private String leaderName;
    
    private String contactNumber;
    
    private Date tenderTime;
    
    private int status;
    
    public String getCarrierName()
    {
        return carrierName;
    }
    
    public void setCarrierName(String carrierName)
    {
        this.carrierName = carrierName;
    }
    
    public String getCarrierCode()
    {
        return carrierCode;
    }
    
    public void setCarrierCode(String carrierCode)
    {
        this.carrierCode = carrierCode;
    }
    
    public String getFactoryName()
    {
        return factoryName;
    }
    
    public void setFactoryName(String factoryName)
    {
        this.factoryName = factoryName;
    }
    
    public String getFactoryCode()
    {
        return factoryCode;
    }
    
    public void setFactoryCode(String factoryCode)
    {
        this.factoryCode = factoryCode;
    }
    
    public String getCompanyQualification()
    {
        return companyQualification;
    }
    
    public void setCompanyQualification(String companyQualification)
    {
        this.companyQualification = companyQualification;
    }
    
    public String getRegisteredMoney()
    {
        return registeredMoney;
    }
    
    public void setRegisteredMoney(String registeredMoney)
    {
        this.registeredMoney = registeredMoney;
    }
    
    public int getVehicleNum()
    {
        return vehicleNum;
    }
    
    public void setVehicleNum(int vehicleNum)
    {
        this.vehicleNum = vehicleNum;
    }
    
    public String getLeaderName()
    {
        return leaderName;
    }
    
    public void setLeaderName(String leaderName)
    {
        this.leaderName = leaderName;
    }
    
    public String getContactNumber()
    {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }
    
    public Date getTenderTime()
    {
        return tenderTime;
    }
    
    public void setTenderTime(Date tenderTime)
    {
        this.tenderTime = tenderTime;
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void setStatus(int status)
    {
        this.status = status;
    }
}
