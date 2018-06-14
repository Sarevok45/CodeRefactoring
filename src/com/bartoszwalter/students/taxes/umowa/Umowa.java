package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.config.Result;
import com.bartoszwalter.students.taxes.config.WorkParms;

public abstract class Umowa {
    protected WorkParms parms;

    public Umowa() {
        this.parms = new WorkParms();
    }

    public Umowa(WorkParms parms) {
        this.parms = parms;
    }

    public void setParms(WorkParms parms) {
        this.parms = parms;
    }


    public abstract Result Calculate();
}
