# LowBattery 

* Library for competitive programming, and interview question preparation. Also, contains solutions for leetcode questions, classified by levels and topics. Author has also tried to depict some usage of clean code. 

* This repository will also contains materials around SOLID, JVM, System Design.

## Create a new question

* `java com.codr.framework.Bootstrap <QuestionName> <QuestionTopic> <QuestionLevel>`
* Extend <QuestionName.java> with Question.java, and use output, input models of question for generic parameters.
* Sample: `public class XYZ extends Question<XYZOutput, XYZInput> {}`
* In `Main.java` create the object of `<QuestionName>.java`, and invoke `process` method. 
* NOTE: The new question file need to implement `solve`, `display` and `takeInput` model, which is invoked by `process` method.

