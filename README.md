#Second Homework

Изучить параметры которые предоставляет аннотации @SpringBootApplication
* exclude - исключить определенные классы из автоконфигурации
* excludeName - исключить определенные классы из автоконфигурации по их имени
* nameGenerator - класс, унаследовавший BeanNameGenerator, который будет использоваться для именования элементов в контейнере Spring'а
* proxyBeanMethods - false: создает новый бин каждый раз, когда мы обращаемся к методу, true: использует один и тот же бин
* scanBasePackages - указывает, какие пакеты нужно сканировать для создания бинов средствами Spring
* scanBasePackageClasses - типобезопасная альтернатива scanBasePackages
