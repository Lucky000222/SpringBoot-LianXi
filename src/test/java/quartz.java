import com.security.Quartz.QuartzUtil;
import com.security.TemplateJob;
import org.quartz.JobDataMap;

public class quartz {
    public static void main(String[] args) {
//        JobDataMap jobDataMap = new JobDataMap();
//        jobDataMap.put("222","333");
//        String userId = jobDataMap.getString("userId");
//        String awardName = jobDataMap.getString("awardName");
//        String awardId = jobDataMap.getString("awardId");
//        double awardValue = jobDataMap.getDouble("awardValue");

        QuartzUtil.addJob("111","111", TemplateJob.class,"0/10 * * * * ?",null);
    }
}
