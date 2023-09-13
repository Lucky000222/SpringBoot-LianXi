import com.security.Quartz.QuartzUtil;
import com.security.TemplateJob;

import java.util.ArrayList;

public class quartz2 {
    public static void main(String[] args) {
        QuartzUtil.addJob("222","222", TemplateJob.class,"0/15 * * * * ?",null);


    }
}
