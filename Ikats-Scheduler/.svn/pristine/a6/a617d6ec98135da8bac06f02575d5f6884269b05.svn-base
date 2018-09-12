package com.ikats.scheduler.logic;



import java.util.Map;


public abstract class AbstractLogic {

    private Boolean success;
    private String message;
    private String code;

    public void clear()
    {
        success=false;
        message="";
        code="";
    }

    protected Long getExpress(Map<String,String> express, String name){
        if(express==null)
            return -1L;
        if (express.size()>0&&express.containsKey(name))
        {
            String value=express.get(name);
            if(value!=null && !"".equals(value))
            {
                return  Long.parseLong(value);
            }
            return -1L;
        }
        return -1L;
    }


    protected Integer getIntegerExpress(Map<String,String> express,String name){
        if(express==null)
            return -1;
        if (express.size()>0&&express.containsKey(name))
        {
            String value=express.get(name);
            if(value!=null && !"".equals(value))
            {
                return  Integer.parseInt(value);
            }
            return -1;
        }
        return -1;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
