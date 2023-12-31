package deginepattern;

/**
 * 템플릿 콜백 패턴은 전략 패턴의 번형으로, 스프링의 3대 프로그래밍 모델 중 하나인 DI (의존성 주입)에서 사용하는 특별한 형태의 전략 패턴이다.
 * 템플릿 콜백 패턴은 전략 패턴과 모든 것이 동일한데 전략을 익명 내부 클래스로 정의해서 사용한다는 특징이 있다.
 *
 * 템플릿 콜백 패턴(Template Callback Pattern)은 메서드 호출 시 특정 부분을 서브클래스에서 구현할 수 있도록 하는 패턴입니다.
 * 자바에서는 주로 인터페이스나 추상 클래스를 활용하여 구현됩니다.
 * 아래는 간단한 템플릿 콜백 패턴의 예제 코드입니다.
 *
 * 주로 익명 내부 클래스를 활용해 구현이 된다.
 *템플릿 콜백 패턴은 주로 비동기적인 작업이나 이벤트 핸들링과 관련이 있습니다.
 * 아래는 간단한 비동기 작업을 처리하는 템플릿 콜백 패턴의 예제 코드입니다.
 */
public class TemplateCallbackPattern {

    public static void main(String[] args) {
        // 비동기 작업을 처리하는 템플릿을 이용한 클라이언트 코드
        AsyncOperationTemplate asyncOperation = new AsyncOperationTemplate();

        // 비동기 작업 수행 및 결과에 따른 콜백 처리
        asyncOperation.executeAsyncOperation(new AsyncCallback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Success: " + result);
            }

            @Override
            public void onFailure(String error) {
                System.out.println("Failure: " + error);
            }
        });
    }
}
// 비동기 작업을 수행하는 인터페이스
interface AsyncCallback {
    void onSuccess(String result);
    void onFailure(String error);
}

// 비동기 작업을 처리하는 템플릿
class AsyncOperationTemplate {
    // 템플릿 메서드: 비동기 작업의 일반적인 과정을 정의
    public final void executeAsyncOperation(AsyncCallback callback) {
        startAsyncOperation();

        // 비동기 작업의 결과에 따라 호출되는 콜백 메서드
        if (operationSucceeded()) {
            callback.onSuccess("Operation succeeded");
        } else {
            callback.onFailure("Operation failed");
        }

        endAsyncOperation();
    }

    // 서브클래스에서 구현해야 하는 비동기 작업 시작 메서드
    protected void startAsyncOperation() {
        System.out.println("Async operation started");
    }

    // 서브클래스에서 구현해야 하는 비동기 작업 성공 여부를 확인하는 메서드
    protected boolean operationSucceeded() {
        return true;
    }

    // 서브클래스에서 구현해야 하는 비동기 작업 종료 메서드
    protected void endAsyncOperation() {
        System.out.println("Async operation ended");
    }
}
