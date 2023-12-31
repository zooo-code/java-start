package solid;

/**
 * 단일 책임의 원칙(Single Responsibility Principle, SRP)은 소프트웨어 설계 원칙 중 하나로,
 * 한 클래스는 하나의 책임만 가져야 한다는 원칙입니다. 클래스를 변경해야 하는 이유는 오직 하나뿐이어야 한다는 것을 의미합니다.
 * 이렇게 하면 클래스가 한 가지 기능에만 집중하게 되므로 유지보수가 쉬워지고 코드의 응집성이 향상됩니다.
 */
public class SingleResponsibility {
    public static void main(String[] args) {
        // 단일 책임의 원칙을 따르지 않은 경우
        ReportNotSingle report1 = new ReportNotSingle();
        report1.generateReport();
        report1.saveToFile();
        report1.sendByEmail("example@example.com");

        System.out.println();

        // 단일 책임의 원칙을 따른 경우
        ReportSingle report2 = new ReportSingle();
        report2.generateReport();
        report2.saveToFile();

        ReportMailer reportMailer = new ReportMailer();
        reportMailer.sendByEmail(report2, "example@example.com");
    }

}
// 단일 책임의 원칙을 따르지 않은 경우
class ReportNotSingle {
    private String content;

    public void generateReport() {
        // 보고서 생성 로직
        System.out.println("Generating report...");
        this.content = "Report content";
    }

    public void saveToFile() {
        // 파일에 저장하는 로직
        System.out.println("Saving report to file: " + this.content);
    }

    public void sendByEmail(String email) {
        // 이메일 전송 로직
        System.out.println("Sending report to " + email);
    }
}

// 단일 책임의 원칙을 따른 경우
class ReportSingle {
    private String content;

    public void generateReport() {
        // 보고서 생성 로직
        System.out.println("Generating report...");
        this.content = "Report content";
    }

    public void saveToFile() {
        // 파일에 저장하는 로직
        System.out.println("Saving report to file: " + this.content);
    }
}

class ReportMailer {
    public void sendByEmail(ReportSingle report, String email) {
        // 이메일 전송 로직
        System.out.println("Sending report to " + email);
    }
}
