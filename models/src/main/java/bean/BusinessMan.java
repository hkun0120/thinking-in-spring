package bean;

/**
 * @description: 商人
 * @author: H.K
 * @program: thinking-in-spring
 * @create: 2020-04-12 19:39
 */
public class BusinessMan extends People {
    // 行业
    private String industry;
    // 利润率
    private String profitRate;

    public BusinessMan() {
    }

    public BusinessMan(String name, String age, String industry, String profitRate) {
        super(name, age);
        this.industry = industry;
        this.profitRate = profitRate;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(String profitRate) {
        this.profitRate = profitRate;
    }

    @Override
    public String toString() {
        return "BusinessMan{" +
                "industry='" + industry + '\'' +
                ", profitRate='" + profitRate + '\'' +
                '}';
    }
}
