package bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TechnologyPlan {
    private String technologyPlanId;

    private String technologyId;

    private Integer batchAmount;

    private Date startPlan;

    private Date endPlan;

    private Date commitPlan;

    private Date technologyPlanStart;

    private Date technologyPlanEnd;
    private String technologyName;

    @Override
    public String toString() {
        return "TechnologyPlan{" +
                "technologyPlanId='" + technologyPlanId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", batchAmount=" + batchAmount +
                ", startPlan=" + startPlan +
                ", endPlan=" + endPlan +
                ", commitPlan=" + commitPlan +
                ", technologyPlanStart=" + technologyPlanStart +
                ", technologyPlanEnd=" + technologyPlanEnd +
                ", technologyName='" + technologyName + '\'' +
                '}';
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }



    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId == null ? null : technologyPlanId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public Integer getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Integer batchAmount) {
        this.batchAmount = batchAmount;
    }

    public Date getStartPlan() {
        return startPlan;
    }

    /*public void setStartPlan(Date startPlan) {
        this.startPlan = startPlan;
    }*/
    public void setStartPlan(String startPlan) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.startPlan =sdf.parse(startPlan);
    }

    public Date getEndPlan() {
        return endPlan;
    }

   /* public void setEndPlan(Date endPlan) {
        this.endPlan = endPlan;
    }*/
    public void setEndPlan(String endPlan) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.endPlan =sdf.parse(endPlan);
    }

    public Date getCommitPlan() {
        return commitPlan;
    }

   /* public void setCommitPlan(Date commitPlan) {
        this.commitPlan = commitPlan;
    }*/
    public void setCommitPlan(String commitPlan) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.commitPlan =sdf.parse(commitPlan);
    }

    public Date getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    /*public void setTechnologyPlanStart(Date technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }*/
    public void setTechnologyPlanStart(String technologyPlanStart) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.technologyPlanStart =sdf.parse(technologyPlanStart);
    }
    public Date getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

   /* public void setTechnologyPlanEnd(Date technologyPlanEnd) {

        this.technologyPlanEnd = technologyPlanEnd;
    }*/

    public void setTechnologyPlanEnd(String technologyPlanEnd) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.technologyPlanEnd =sdf.parse(technologyPlanEnd);
    }
}