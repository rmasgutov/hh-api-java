package ru.hhapijava.dto.dictionary

class CommonDictionary {

    enum ApplicantCommentAccessType {
        COWORKERS('Виден мне и моим коллегам'),
        OWNER('Виден только мне'),
        private String name;

        ApplicantCommentAccessType(String name) {
            this.name = name
        }
    }

    enum ApplicantCommentsOrder {
        CREATION_TIME_DESC('по убыванию даты публикации'),
        CREATION_TIME_ASC('по дате публикации'),
        private String name;

        ApplicantCommentsOrder(String name) {
            this.name = name
        }
    }

    enum BusinessTripReadiness {
        READY('готов к командировкам'),
        SOMETIMES('готов к редким командировкам'),
        NEVER('не готов к командировкам'),
        private String name;

        BusinessTripReadiness(String name) {
            this.name = name
        }
    }

    enum Currency {
        RUR('руб.', true, 'Рубли', 1),
        AZN('AZN', false, 'Манаты', 0.025293),
        BYR('бел. руб.', false, 'Белорусские рубли', 0.030177),
        EUR('EUR', true, 'Евро', 0.013802),
        GEL('GEL', false, 'Грузинский лари', 0.0344),
        KGS('KGS', false, 'Киргизский сом', 1.077158),
        KZT('KZT', false, 'Тенге', 5.299192),
        UAH('грн.', false, 'Гривны', 0.394907),
        USD('USD', true, 'Доллары', 0.01564),
        UZS('UZS', false, 'Узбекский сум', 46.638093),
        private String abbr
        private boolean inUse
        private String name
        private double rate

        Currency(String abbr, boolean inUse, String name, double rate) {
            this.abbr = abbr
            this.inUse = inUse
            this.name = name
            this.rate = rate
        }
    }

    enum EducationLevel {
        HIGHER('Высшее'),
        BACHELOR('Бакалавр'),
        MASTER('Магистр'),
        CANDIDATE('Кандидат наук'),
        DOCTOR('Доктор наук'),
        UNFINISHED_HIGHER('Неоконченное высшее'),
        SECONDARY('Среднее'),
        SPECIAL_SECONDARY('Среднее специальное'),
        private String name;

        EducationLevel(String name) {
            this.name = name
        }
    }

    enum EmployerActiveVacanciesOrder {
        EXPIRATION_DATE_DESC('по убыванию даты'),
        EXPIRATION_DATE_ASC('по дате'),
        NAME_DESC('по заголовку, в обратном порядке'),
        NAME_ASC('по заголовку'),
        private String name;

        EmployerActiveVacanciesOrder(String name) {
            this.name = name
        }
    }

    enum EmployerArchivedVacanciesOrder {
        ARCHIVE_TIME_ASC('по дате архивации'),
        ARCHIVE_TIME_DESC('по убыванию даты архивации'),
        NAME_DESC('по заголовку, в обратном порядке'),
        NAME_ASC('по заголовку'),
        private String name;

        EmployerArchivedVacanciesOrder(String name) {
            this.name = name
        }
    }

    enum EmployerHiddenVacanciesOrder {
        ARCHIVE_TIME_ASC('по дате архивации'),
        ARCHIVE_TIME_DESC('по убыванию даты архивации'),
        NAME_DESC('по заголовку, в обратном порядке'),
        NAME_ASC('по заголовку'),
        private String name;

        EmployerHiddenVacanciesOrder(String name) {
            this.name = name
        }
    }

    enum EmployerRelation {
        BLACKLISTED('Скрыт из поиска вакансий'),
        private String name;

        EmployerRelation(String name) {
            this.name = name
        }
    }

    enum EmployerType {
        COMPANY('Прямой работодатель'),
        AGENCY('Кадровое агентство'),
        PRIVATE_RECRUITER('Частный рекрутер'),
        private String name;

        EmployerType(String name) {
            this.name = name
        }
    }

    enum Employment {
        FULL('Полная занятость'),
        PART('Частичная занятость'),
        PROJECT('Проектная работа'),
        VOLUNTEER('Волонтерство'),
        PROBATION('Стажировка'),
        private String name;

        Employment(String name) {
            this.name = name
        }
    }

    enum Experience {
        NOEXPERIENCE('Нет опыта'),
        BETWEEN1AND3('От 1 года до 3 лет'),
        BETWEEN3AND6('От 3 до 6 лет'),
        MORETHAN6('Более 6 лет'),
        private String name;

        Experience(String name) {
            this.name = name
        }
    }

    enum Gender {
        MALE('Мужской'),
        FEMALE('Женский'),
        private String name;

        Gender(String name) {
            this.name = name
        }
    }

    enum LanguageLevel {
        BASIC('базовые знания'),
        CAN_READ('читаю профессиональную литературу'),
        CAN_PASS_INTERVIEW('могу проходить интервью'),
        FLUENT('свободно владею'),
        NATIVE('родной'),
        private String name;

        LanguageLevel(String name) {
            this.name = name
        }
    }

    enum MessagingStatus {
        OK('Переписка доступна'),
        ARCHIVED('Вакансия отправлена в архив'),
        DISABLED_BY_EMPLOYER('Работодатель отключил переписку'),
        RESUME_DELETED('Резюме удалено'),
        IN_A_ROW_LIMIT('Вы отправили 5 сообщений подряд. Дождитесь ответа, чтобы написать еще'),
        NO_INVITATION('Переписка доступна только после приглашения'),
        OVERALL_LIMIT('Превышено число сообщений в переписке'),
        PROHIBITED('Переписка недоступна'),
        private String name;

        MessagingStatus(String name) {
            this.name = name
        }
    }

    enum NegotiationsOrder {
        UPDATED_AT('по дате обновления'),
        CREATED_AT('по дате добавления'),
        private String name;

        NegotiationsOrder(String name) {
            this.name = name
        }
    }

    enum NegotiationsParticipantType {
        APPLICANT('Соискатель'),
        EMPLOYER('Работодатель'),
        private String name;

        NegotiationsParticipantType(String name) {
            this.name = name
        }
    }

    enum NegotiationsState {
        RESPONSE('Отклик'),
        INVITATION('Приглашение'),
        DISCARD('Отказ'),
        DISCARD_AFTER_INTERVIEW('Отказ после интервью'),
        HIDDEN('Скрытый'),
        TEXT('Текст'),
        private String name;

        NegotiationsState(String name) {
            this.name = name
        }
    }

    enum PreferredContactType {
        HOME('Домашний телефон'),
        WORK('Рабочий телефон'),
        CELL('Мобильный телефон'),
        EMAIL('Эл. почта'),
        private String name;

        PreferredContactType(String name) {
            this.name = name
        }
    }

    enum RelocationType {
        NO_RELOCATION('не готов к переезду'),
        RELOCATION_POSSIBLE('готов к переезду'),
        RELOCATION_DESIRABLE('хочу переехать'),
        private String name;

        RelocationType(String name) {
            this.name = name
        }
    }

    enum ResumeAccessType {
        NO_ONE('не видно никому'),
        WHITELIST('видно выбранным компаниям'),
        BLACKLIST('скрыто от выбранных компаний'),
        CLIENTS('видно всем компаниям, зарегистрированным на HeadHunter'),
        EVERYONE('видно всему интернету'),
        DIRECT('доступно только по прямой ссылке'),
        private String name;

        ResumeAccessType(String name) {
            this.name = name
        }
    }

    enum ResumeContactsSiteType {
        PERSONAL('Другой сайт'),
        MOI_KRUG('Мой круг'),
        LIVEJOURNAL('LiveJournal'),
        LINKEDIN('LinkedIn'),
        FREELANCE('Free-lance'),
        FACEBOOK('Facebook'),
        SKYPE('Skype'),
        ICQ('ICQ'),
        JABBER('Jabber'),
        private String name;

        ResumeContactsSiteType(String name) {
            this.name = name
        }
    }

    enum ResumeModerationNote {
        BAD('Резюме составлено небрежно.'),
        BLOCK_FULL_NAME('В резюме отсутствует полное имя кандидата.'),
        BAD_DESCRIPTION('Укажите желаемую позицию, чтобы повысить свои шансы найти работу.'),
        BLOCK_NO_EDUCATION_PLACE_OR_DATE('Отсутствуют данные об учебном заведении и дате его окончания.'),
        BAD_EDUCATION('Плохо описано образование.'),
        BAD_EDUCATION_STUDENT('Укажите полное название учебного заведения, факультет и планируемый год окончания.'),
        BLOCK_NO_FUNCTION('Опишите подробнее свои обязанности и функции.'),
        BLOCK_WORK_PLACE('Не указан опыт работы за последнее время'),
        NO_COMPANY_NAME('Укажите названия мест работы.'),
        NO_COMPANY_DESCRIPTION('Укажите сферу деятельности компаний, в которых Вы работали.'),
        NO_POSITION('Плохо описаны занимаемые должности.'),
        NO_DATE('Отсутствуют даты начала и окончания работы.'),
        BAD_FUNCTION('Плохо описаны функции и обязанности.'),
        NOT_ENOUGH_INFORMATION('Укажите больше дополнительной информации: владение иностранными языками, знание компьютерных программ и др.'),
        LOT_INFORMATION('Слишком много дополнительной информации.'),
        NO_RECOMMENDATION('Вы не предоставили ни одну рекомендацию.'),
        CARELESS_ADDITIONAL_INFORMATION('Обратите внимание на раздел «Ключевые навыки». Укажите в нём сведения, которые выгодно отличат Вас в качестве претендента на желаемую позицию. Проверьте орфографию и опечатки.'),
        CARELESS_PHOTO('Рекомендуем Вам изменить фотографию для резюме. Лучше размещать фотографии, где Вы изображены в деловом или повседневном костюме.'),
        CARELESS_KEY_SKILL_INFORMATION('Отредактируйте раздел «Ключевые навыки» Вашего резюме, поскольку указанная информация не вполне соответствует формату и/или содержит опечатки.'),
        INCORRECT_PHONE_NUMBER('В резюме указан несуществующий номер телефона. Если номер корректен, свяжитесь со службой поддержки'),
        private String name;

        ResumeModerationNote(String name) {
            this.name = name
        }
    }

    enum ResumeSearchExperiencePeriod {
        ALL_TIME('за всё время опыта'),
        LAST_YEAR('за последний год'),
        LAST_THREE_YEARS('за последние 3 года'),
        LAST_SIX_YEARS('за последние 6 лет'),
        private String name;

        ResumeSearchExperiencePeriod(String name) {
            this.name = name
        }
    }

    enum ResumeSearchFields {
        EVERYWHERE('везде'),
        TITLE('в названии резюме'),
        EDUCATION('в образовании'),
        SKILLS('в ключевых навыках'),
        EXPERIENCE('в опыте работы'),
        EXPERIENCE_COMPANY('в компаниях и отраслях'),
        EXPERIENCE_POSITION('в должностях'),
        EXPERIENCE_DESCRIPTION('в обязанностях'),
        private String name;

        ResumeSearchFields(String name) {
            this.name = name
        }
    }

    enum ResumeSearchLabel {
        ONLY_WITH_PHOTO('Только с фотографией'),
        ONLY_WITH_SALARY('Не показывать резюме без зарплаты'),
        ONLY_WITH_AGE('Не показывать резюме без указания возраста'),
        ONLY_WITH_GENDER('Не показывать резюме без указания пола'),
        private String name;

        ResumeSearchLabel(String name) {
            this.name = name
        }
    }

    enum ResumeSearchLogic {
        ALL('Все слова встречаются'),
        ANY('Любое из слов встречается'),
        PHRASE('Точная фраза встречается'),
        EXCEPT('Не встречаются'),
        private String name;

        ResumeSearchLogic(String name) {
            this.name = name
        }
    }

    enum ResumeSearchOrder {
        PUBLICATION_TIME('по дате изменения'),
        SALARY_DESC('по убыванию зарплат'),
        SALARY_ASC('по возрастанию зарплаты'),
        RELEVANCE('по соответствию'),
        private String name;

        ResumeSearchOrder(String name) {
            this.name = name
        }
    }

    enum ResumeSearchRelocation {
        LIVING_OR_RELOCATION('Живут в указанном регионе или готовы переехать в него'),
        LIVING('Живут в указанном регионе'),
        LIVING_BUT_RELOCATION('Живут в указанном регионе и готовы к переезду куда-либо'),
        RELOCATION('Не живут в указанном регионе, но готовы переехать в него'),
        private String name;

        ResumeSearchRelocation(String name) {
            this.name = name
        }
    }

    enum ResumeStatus {
        NOT_PUBLISHED('не опубликовано'),
        PUBLISHED('опубликовано'),
        BLOCKED('заблокировано'),
        ON_MODERATION('на модерации'),
        private String name;

        ResumeStatus(String name) {
            this.name = name
        }
    }

    enum Schedule {
        FULLDAY('Полный день'),
        SHIFT('Сменный график'),
        FLEXIBLE('Гибкий график'),
        REMOTE('Удаленная работа'),
        FLYINFLYOUT('Вахтовый метод'),
        private String name;

        Schedule(String name) {
            this.name = name
        }
    }

    enum TravelTime {
        ANY('Не имеет значения'),
        LESS_THAN_HOUR('Не более часа'),
        FROM_HOUR_TO_ONE_AND_HALF('Не более полутора часов'),
        private String name;

        TravelTime(String name) {
            this.name = name
        }
    }

    enum VacancyBillingType {
        FREE('Бесплатная'),
        STANDARD('Стандарт'),
        STANDARD_PLUS('Стандарт+'),
        PREMIUM('Премиум'),
        private String name;

        VacancyBillingType(String name) {
            this.name = name
        }
    }

    enum VacancyCluster {
        SPECIALIZATION('Специализация'),
        METRO('Метро'),
        SCHEDULE('График работы'),
        INDUSTRY('Отрасль компании'),
        AREA('Регион'),
        EXPERIENCE('Опыт работы'),
        LABEL('Исключение'),
        SALARY('Зарплата'),
        EMPLOYMENT('Тип занятости'),
        PROFESSIONAL_AREA('Профобласть'),
        private String name;

        VacancyCluster(String name) {
            this.name = name
        }
    }

    enum VacancyLabel {
        WITH_ADDRESS('Только с адресом'),
        ACCEPT_HANDICAPPED('Только доступные для людей с инвалидностью'),
        NOT_FROM_AGENCY('Без вакансий агентств'),
        private String name;

        VacancyLabel(String name) {
            this.name = name
        }
    }

    enum VacancyNotProlongedReason {
        VACANCY_ARCHIVED('Вы не можете продлевать архивную/заблокированную вакансию.'),
        NOT_ENOUGH_QUOTAS('Вакансия не может быть обновлена. Квота на публикацию исчерпана.'),
        FREE_PROLONGATION_NOT_AVAILABLE('Бесплатная вакансия не может быть обновлена.'),
        TOO_EARLY_TO_PROLONGATE_FREE_RMR_PUBLICATION('Объявление не может быть обновлено, т.к. предыдущее обновление было менее трех дней назад.'),
        TOO_EARLY_TO_PROLONGATE_FREE_PUBLICATION('Бесплатная вакансия не может быть обновлена, т.к. предыдущее обновление было менее трех дней назад.'),
        NOT_ENOUGH_PURCHASED_SERVICES('Вакансия не может быть обновлена. Недостаточно купленных услуг.'),
        TOO_EARLY_TO_PROLONGATE_STANDARD_PUBLICATION('Вакансия "Стандарт" не может быть обновлена, т.к. предыдущее обновление было менее трех дней назад.'),
        STANDARD_PLUS_CANNOT_BE_CLOSED('Вакансия "Стандарт Плюс" не может быть закрытой.'),
        STANDARD_PLUS_PUBLICATION_IS_UPDATED_AUTOMATICALLY('Вакансия "Стандарт Плюс" не может быть обновлена, это происходит автоматически раз в три дня.'),
        private String name;

        VacancyNotProlongedReason(String name) {
            this.name = name
        }
    }

    enum VacancyRelation {
        FAVORITED('В отобранных'),
        GOT_RESPONSE('Вы отправили резюме'),
        GOT_INVITATION('Вас пригласили'),
        GOT_REJECTION('Вам отказали'),
        BLACKLISTED('Скрыта из поиска'),
        private String name;

        VacancyRelation(String name) {
            this.name = name
        }
    }

    enum VacancySearchFields {
        NAME('в названии вакансии'),
        COMPANY_NAME('в названии компании'),
        DESCRIPTION('в описании вакансии'),
        private String name;

        VacancySearchFields(String name) {
            this.name = name
        }
    }

    enum VacancySearchOrder {
        PUBLICATION_TIME('по дате'),
        SALARY_DESC('по убыванию зарплаты'),
        SALARY_ASC('по возрастанию зарплаты'),
        RELEVANCE('по соответствию'),
        DISTANCE('по удалённости'),
        private String name;

        VacancySearchOrder(String name) {
            this.name = name
        }
    }

    enum VacancySite {
        HH('hh.ru'),
        RMR('rabota.mail.ru'),
        private String name;

        VacancySite(String name) {
            this.name = name
        }
    }

    enum VacancyType {
        OPEN('Открытая'),
        CLOSED('Закрытая'),
        ANONYMOUS('Анонимная'),
        DIRECT('Рекламная'),
        private String name;

        VacancyType(String name) {
            this.name = name
        }
    }


}
