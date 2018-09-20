
/**
 * @author yuhea
 * @date 15:51 2017/11/14
 */
public class QA {
    int sortId;
    int promotionId;
    int productLineId;
    //boolean isDomestic;
    String content;

    public QA(int sortId, int promotionId, int productLineId, String content) {
        this.sortId = sortId;
        this.promotionId = promotionId;
        this.productLineId = productLineId;
        // this.isDomestic = iDdomestic;
        this.content = content;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(int productLineId) {
        this.productLineId = productLineId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
