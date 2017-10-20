#JobLauncher 
    任务启动器，通过它来启动任务，程序的入口。public JobExecution
    run(Job job, JobParameters jobParameter) throws JobExecution...
    spring batch框架提供了一个JobLauncher的实现类SimpleJobLauncher
#Job
    代表一个具体的任务。 一个Job于一个或多个JobInstance相关联，而
    一个JobInstance又与一个或多个JobExecution关联
#Step
    具体的一个步骤，一个job可以包含多个step。 
    --- ItemReader代表读操作。spring-batch框架提供了多种ItemReader接口的实现类，包括
    对文本文件、xml、数据库、JMS消息等读的处理
    --- ItemProcessor 代表处理操作 O process(I item) throws ..
    process方法的形参传入I类型的对象，通过处理后返还O型的对象
    --- ItemWriter 代表写操作 void write(List<? extends T> items) throws Exception
    
#JobRepository
    存储数据。比如任务执行的状态。框架提供了两种实现，一种是通过
    map形式保存在内存中，当Java程序重启后任务信息也就丢失了，并且
    在分布式无法获取其他界定啊的任务执行情况；另一种是保存在数据库
    中，BATCH_JOB_INSTANCE BATCH_JOB_EXECUTION_PARAMS  BATCH_JOB_EXECUTION
    BATCH_STEP_EXECUTION  BATCH_JOB_EXECUTION_CONTEXT  BATCH_STEP_EXECUTION_CONTEXT