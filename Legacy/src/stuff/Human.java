package stuff;

import stuff.jobs.IJob;

import static stuff.jobs.NullJob.getNullJob;

public class Human {
    private IJob job;
    private int level;
    //funcion edad-eficiencia

    public IJob getJob() {
        return job;
    }

    public Human() {
        this.job = getNullJob();
        this.level = 1;
    }

    public void setJob(IJob job) {
        this.job = job;
    }

    public int getLevel() {
        return level;
    }

    void work(){
        job.excecuteJob(level);
    }



}
