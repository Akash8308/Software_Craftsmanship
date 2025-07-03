# Hotel Automation

## Analysis
1. A Hotel can have multiple floors
2. Each floor can have multiple main corridors and sub corridors
3. Both main corridor and sub corridor have one light each
4. Both main and sub corridor lights consume 5 units of power when ON
5. Both main and sub corridor have independently controllable ACs
6. Both main and sub corridor ACs consume 10 units of power when ON
7. All the lights in all the main corridors need to be switched ON between 6PM to 6AM,
which is the Night Time slot
8. By default, all ACs are switched ON, all the time
9. When a motion is detected in one of the sub corridors the corresponding lights need to
be switched ON between 6PM to 6AM (Night Time slot)
10. The total power consumption of all the ACs and lights combined should not exceed
(Number of Main corridors * 15) + (Number of sub corridors * 10) units of per floor. Sub
corridor AC could be switched OFF to ensure that the power consumption is not more
than the specified maximum value
11. When there is no motion for more than a minute the sub corridor lights should be
switched OFF and AC needs to be switched ON

## Questions
- Why AC needs to be switched ON? (Analysis Point 11)
- Do we need functionality to Add/Remove corridor/light/AC?


## Classes
 * Hotel
   * Attributes: id : int, name: String, floors: Floor
   * Behavior: get/set,
 
* Floor
  * Attributes: id: int, name: String, mainCorridors: List<MainCorridor>, subCorridors: List<SubCorridor>
  * Behavior: get/set, addCorridor(), addSubCorridor()

* Corridor
 * Attributes: id: int, name: String, light: Light, List<ac>: AC, time: LocalTime
 * Behavior: get/set, turnAcON(), turnAcOff(), turnLightON(), turnLightOff()

[//]: # (* MainCorridor)

[//]: # (  * Attributes: id: int, name: String, light: Light, List<ac>: AC, time: LocalTime)

[//]: # (  * Behavior: get/set, turnAcON&#40;&#41;, turnAcOff&#40;&#41;, turnLightON&#40;&#41;, turnLightOff&#40;&#41;)

[//]: # (All the lights in all the main corridors need to be switched ON between 6PM to 6AM,)
[//]: # (which is the Night Time slot)

[//]: # (* SubCorridor extends Corridor)

[//]: # (When a motion is detected in one of the sub corridors the corresponding lights need to)

[//]: # (be switched ON between 6PM to 6AM &#40;Night Time slot&#41;)

* Light
  * Attributes: id: String, power: POWER_STATUS, countDownSinceLastMotionDetected: LocalTime
  * Behavior: get/set,
  
[//]: # ( Both main and sub corridor lights consume 5 units of power when ON)

* AC 
  * Attributes: id: String, power: POWER_STATUS = POWER_STATUS.ON, countDownSinceLastMotionDetected: LocalTime
  * Behavior: get/set, 

[//]: # (Both main and sub corridor ACs consume 10 units of power when ON)

* MotionDetector
  * Attributes: id: int, name: String, input : bool 
  * Behavior: get/set(), detectMotion()

## Enum
* POWER_STATUS = { ON, OFF }
* TIME_SLOT = { DAY, NIGHT }