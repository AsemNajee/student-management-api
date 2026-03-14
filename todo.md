# Student Management

this is api to manage students by there teachers\
this application is managing degrees, behaviors

## Entities

- Student
- Subject
- Teacher
- ClassRoom
- DailyDegrees
- MidTermDegree
- FinalExamDegree

### Entities informations

#### Student

| column      | type       | info                                 |
| ----------- | ---------- | ------------------------------------ |
| name        | `string`   | name of student                      |
| phone       | `string`   | phone of student                     |
| parentPhone | `string`   | parent of student phone              |
| class       | `relation` | class of student studing in          |
| dateOfJoin  | `date`     | date of join in (default is current) |
| dateOfBirth | `date`     | date of student birth                |

#### Subject

| column          | type       | info                     |
| --------------- | ---------- | ------------------------ |
| name            | `string`   | name of subject          |
| fullMark        | `double`   | full mark of degrees     |
| presentDegree   | `double`   | daily degree of presents |
| behaviorDegree  | `double`   | daily degree of behavior |
| midTermDegree   | `double`   | midterm exam degree      |
| finalExamDegree | `double`   | midterm exam degree      |
| teacher         | `relation` | teacher of it            |

#### Teacher

| column | type     | info            |
| ------ | -------- | --------------- |
| name   | `string` | name of teacher |

### DailyDegrees

| column      | type       | info                                            |
| ----------- | ---------- | ----------------------------------------------- |
| student     | `relation` | student hav the degree                          |
| subject     | `relation` | subject of the degree (which linked with class) |
| present     | `boolean`  | if student is present                           |
| shareDegree | `double`   | sharing degrees (optional)                      |

### MidTermDegree

| column   | type       | info                                            |
| -------- | ---------- | ----------------------------------------------- |
| student  | `relation` | student hav the degree                          |
| subject  | `relation` | subject of the degree (which linked with class) |
| increese | `double`   | increese from teacher for excelants students    |
| cheat    | `boolean`  | if student cheat in the exam                    |

### FinalExamDegree

| column   | type       | info                                            |
| -------- | ---------- | ----------------------------------------------- |
| student  | `relation` | student hav the degree                          |
| subject  | `relation` | subject of the degree (which linked with class) |
| increese | `double`   | increese from teacher for excelants students    |
| cheat    | `boolean`  | if student cheat in the exam                    |

## Analysis

### work

يدخل المدرس الفصول او التخصصات او ما شابه  ذلك اعتماداً على المؤسسة التي يديرها

المدرس يقوم بادخال المواد وبياناتها مثل (الاسم ، الدرجة النهائية ، والفصل ، درجة الحضور ، درجة السلوك ، درجة الاختبار النصفي ، درجة الاختبار النهائي)

يدخل الاستاذ بيانات الطلاب وهي (الاسم ، تاريخ الانضمام ، تاريخ الميلاد ، الفصل، رقم الهاتف ، رقم هاتف ولي الامر)

يدخل الاستاذ الدرجات اليومية للطلاب وهي (الطالب ، المادة ، الحضور ، درجات مشاركة -اختياري-)

يدخل الاستاذ درجات الطلاب النصفية للاختبار وهي (الطالب ، الدرجة ، الزيادة ، حالة الغش)

يدخل الاستاذ درجات الطلاب النهائية للاختبار وهي (الطالب ، الدرجة ، الزيادة ، حالة الغش)

### Tests

- adding
  - classRoom
  - subject
  - student
  - dailyDegree
  - finalExamDegree
  - midTermDegree
- link
  - subject <-> classRoom
  - student <-> classRoom

## plan

### Daily Report

| Name | present | share |
| ---- | ------- | ----- |
| Asem | true    | 1     |
| Ali  | true    | 0     |

### All Report

| Name | present | fullpresent | increas | decrease | midTerm | fullMidTerm | finalExam | fullFinalExam |
| ---- | ------- | ----------- | ------- | -------- | ------- | ----------- | --------- | ------------- |
| Asem | 10      | 10          | 1       | 0        | 100     | 100         | 100       | 100           |
| Ali  | 8       | 10          | 0       | 0        | 89      | 100         | 78        | 100           |

#### EndPoints

| METHOD | PATH                             | info                        |
| ------ | -------------------------------- | --------------------------- |
| GET    | /degrees/{subjectId}             | get all degrees for subject |
| POST   | /degrees/{subjectId}             | insert new student degree   |
| GET    | /degrees/{subjectId}/{studentId} | get student degree          |
| PUT    | /degrees/{subjectId}/{studentId} | update degrees for student  |
