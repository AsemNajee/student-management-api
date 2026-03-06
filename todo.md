# Student Management

this is api to manage students by there teachers\
this application is managing degrees, behaviors

## Entities

- Student
- Subject
- Teacher

### Entities informations

#### Student

| column |   type   |       info     |
|--------|----------|----------------|
|  name  | `string` | name of student|

#### Subject

| column |   type   |       info     |
|--------|----------|----------------|
|  name  | `string` | name of subject|
| teacher|`relation`| teacher of it  |

#### Teacher

| column |   type   |       info     |
|--------|----------|----------------|
|  name  | `string` | name of teacher|
