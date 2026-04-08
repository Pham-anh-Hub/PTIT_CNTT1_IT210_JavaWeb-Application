package PTIT_CNTT1_IT210_Session01_Bai5.model;

import java.time.LocalDateTime;

public class SystemConfig {
    private String branchName;
    private String openingHour;

    public SystemConfig() {
        this.branchName = "Cyber Center";
        this.openingHour = String.valueOf(LocalDateTime.now());
    }

    public String getBranchName() {
        return branchName;
    }

    public String getOpeningHour() {
        return openingHour;
    }
}
