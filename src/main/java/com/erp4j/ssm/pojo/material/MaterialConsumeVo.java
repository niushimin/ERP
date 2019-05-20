package com.erp4j.ssm.pojo.material;

import com.erp4j.ssm.pojo.Material;
import com.erp4j.ssm.pojo.work.Work;
import com.erp4j.ssm.pojo.work.WorkVo;

import java.util.Date;


public class MaterialConsumeVo {
    private String consumeId;

    private WorkVo workVo;

    private Material material;

    private Integer consumeAmount;

    private Date consumeDate;

    private String sender;

    private String receiver;

    private String note;

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId;
    }

    public WorkVo getWorkVo() {
        return workVo;
    }

    public void setWorkVo(WorkVo workVo) {
        this.workVo = workVo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
