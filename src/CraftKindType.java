
/**
 * @author yuhea
 * @date 17:53 2018/7/12
 */
public enum CraftKindType {
    S {
        @Override
        public String toString() {
            return "小";
        }
    },
    M {
        @Override
        public String toString() {
            return "中";
        }
    },
    L {
        @Override
        public String toString() {
            return "大";
        }
    }
}
