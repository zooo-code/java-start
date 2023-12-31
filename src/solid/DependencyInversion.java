package solid;

public class DependencyInversion {
    public static void main(String[] args) {
        SwitchableDevice lightBulb = new LightBulb();
        SwitchableDevice fan = new Fan();

        Switch lightSwitch = new Switch(lightBulb);
        Switch fanSwitch = new Switch(fan);

        lightSwitch.press(); // LightBulb를 켬
        lightSwitch.press(); // LightBulb를 끔

        fanSwitch.press();   // Fan을 켬
        fanSwitch.press();   // Fan을 끔
    }
}
// 고수준 모듈
interface SwitchableDevice {
    void turnOn();

    void turnOff();
}

// 저수준 모듈
class LightBulb implements SwitchableDevice {
    @Override
    public void turnOn() {
        System.out.println("LightBulb: ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb: OFF");
    }
}

class Fan implements SwitchableDevice {
    @Override
    public void turnOn() {
        System.out.println("Fan: ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan: OFF");
    }
}

// 고수준 모듈이 저수준 모듈에 직접 의존하지 않고 추상화에 의존하는 예제
class Switch {
    private SwitchableDevice device;

    public Switch(SwitchableDevice device) {
        this.device = device;
    }

    public void press() {
        if (device != null) {
            if (isOn()) {
                device.turnOff();
                setOn(false);
            } else {
                device.turnOn();
                setOn(true);
            }
        }
    }

    private boolean isOn() {
        // 실제로는 어떤 조건에 따라서 상태를 판단할 것입니다.
        return false;
    }

    private void setOn(boolean on) {
        // 실제로는 상태를 변경하는 로직이 들어갈 것입니다.
    }
}