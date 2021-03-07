package encin.datasource.config;

import org.springframework.beans.factory.annotation.Value;


public class DynamicSwitchDBTypeUtil {

    @Value("${spring.datasource.slavecnt}")
    private static int slaveCnt;

    private static final ThreadLocal<DbEnum> CONTEXT_HAND = new ThreadLocal<>();

    public static void set(final DbEnum dbEnum) {
        CONTEXT_HAND.set(dbEnum);
        //        log.info("切换数据源：" + dbEnum);
    }

    public static void master() {
        set(DbEnum.Test);
    }

    public static void slave() {


            set(DbEnum.Test1);


    }

    public static DbEnum get() {
        return CONTEXT_HAND.get();
    }
}
