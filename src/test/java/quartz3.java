/*
public class quartz3 {
    public static void main(String[] args) {
        public List<QuartzEntity> getAllJobs() throws SchedulerException {
            Scheduler scheduler = SCHEDULER_FACTORY.getScheduler();

            List<QuartzEntity> quartzJobs = new ArrayList<>();
            try {
                List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
                for (String groupName : triggerGroupNames) {
                    GroupMatcher<TriggerKey> groupMatcher = GroupMatcher.groupEquals(groupName);
                    Set<TriggerKey> triggerKeySet = scheduler.getTriggerKeys(groupMatcher);
                    for (TriggerKey triggerKey : triggerKeySet) {
                        Trigger trigger = scheduler.getTrigger(triggerKey);
                        JobKey jobKey = trigger.getJobKey();
                        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                        //组装数据
                        QuartzEntity entity = new QuartzEntity();
                        entity.setJobName(jobDetail.getKey().getName());
                        entity.setGroupName(jobDetail.getKey().getGroup());
                        entity.setStartTime(LocalDateTimeUtil.of(trigger.getStartTime()));
                        entity.setEndTime(LocalDateTimeUtil.of(trigger.getStartTime()));
                        entity.setJobClass(jobDetail.getJobClass().getName());
                        if (trigger instanceof CronTrigger) {
                            entity.setCron(((CronTrigger) trigger).getCronExpression());
                        }
                        entity.setJobDataMapJson(JSONUtil.toJsonStr(jobDetail.getJobDataMap()));
                        quartzJobs.add(entity);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return quartzJobs;
        }

    }
}
*/
