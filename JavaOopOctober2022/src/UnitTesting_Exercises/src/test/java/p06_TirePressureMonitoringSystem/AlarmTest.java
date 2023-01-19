package p06_TirePressureMonitoringSystem;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class AlarmTest {

    @Test
    public void testAlarmWithLowPressure() {

        Sensor sensorWithLowPressure = Mockito.mock(Sensor.class);
        when(sensorWithLowPressure.popNextPressurePsiValue()).thenReturn(12.00);

        Alarm alarm = new Alarm(sensorWithLowPressure);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmWithHighPressure() {

        Sensor sensorWithHighPressure = Mockito.mock(Sensor.class);
        when(sensorWithHighPressure.popNextPressurePsiValue()).thenReturn(30.00);

        Alarm alarm = new Alarm(sensorWithHighPressure);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }
    @Test
    public void testAlarmWithNormalPressure() {

        Sensor sensorWithNormalPressure = Mockito.mock(Sensor.class);
        when(sensorWithNormalPressure.popNextPressurePsiValue()).thenReturn(18.00);

        Alarm alarm = new Alarm(sensorWithNormalPressure);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

}