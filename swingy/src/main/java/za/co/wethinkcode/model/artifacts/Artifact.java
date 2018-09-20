package za.co.wethinkcode.model.artifacts;

import javax.validation.constraints.NotNull;

public class Artifact {

    protected String    type;
    @NotNull(message = "Name cannot be null")
    protected String    name;
    protected int       boost;
    protected int       level;

    public Artifact ()
    {
        this.type = "Artifact";
        this.name = "Artifact";
        this.boost = 0;
        this.level = 0;
    }

    public Artifact (int level)
    {
        this.level = level;
    }

    public String getName()
    {
        return this.name;
    }

    public int getBoost()
    {
        return this.boost;
    }

    public String getType()
    {
        return this.type;
    }

}
