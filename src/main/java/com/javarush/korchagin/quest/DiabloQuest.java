package com.javarush.korchagin.quest;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

//todo удалить этот класс после успешного тестирования сервисов работы с бд, также удалить пакет

@Getter
public class DiabloQuest {
    private final List<String> introductionQuest = new ArrayList<>
            (List.of("""
                            Поговорив с Акарой, вы узнаете что в местной пещере завились монстры. Она просит вас разобраться с ними.
                            Почти зачистив пещеру вы встречаете огромного зомби, своими ударами он заставляет застыть кровь в жилах.
                            """,
                    """
                            Успешно справившись с поставленной задачей, вы возвращаетесь в лагерь. К вам подходит молодая, рыжеволосая девушка.
                            Представившись Кешией, она просит вас убить ее бывшую напарницу в ордене, которая обратилась к силам зла.
                            Теперь она известна как Кровавый Ворон.
                            """,
                    """
                            Получив в награду верную напарницу вы вновь идете к Акаре.
                            Она просит вас найти Декарда Кейна, древнего мага из ордена, который ранее изгнал Диабло обратно в преисподнюю. Последний раз его видели в Тристраме.
                            Найдя свиток с древними рунами, вы открываете портал в Тристрам. Там вы находите Декарда Кейна, подвешенного в клетке.
                            """,
                    """
                            Идя вдоль болота, вы находите постамент с книгой, в которой рассказывается история молодой графини, купающейся в крови молодых дев.
                            Решив избавить мир от зла, вы находите развалины замка, в котором обитает графиня.
                            Убив множество врагов, вы наконец приходите к графине, находящейся в окружении своих слуг.
                            """,
                    """
                            Вернувшись после изнурительного сражения в лагерь, вы решаете починить снаряжение. Починив оружие и броню, кузнец просит вас о помощи.
                            Ее древний молот был похищен демоном-кузнецом. Она говорит, что вы найдете его в древнем монастыре.
                            Проследовав множество комнат, вы наконец находите молот, а неподалеку стоит огромный демон с кувалдой в руках.
                            """,
                    """
                            Отдав молот, и улучшив оружие, к вам обращается Кейн и просит уничтожить Андариель, одну из низших правителей Ада.
                            Вы встречаете ее в тронном зале, это огромный трехметровый демон с торчащими из-за спины лапами паука.
                            """));
    private final List<String> positiveAnswer = new ArrayList<>(List.of("Воспользуюсь всеми доступными ресурсами, чтобы победить его",
            "Ловко уворачиваясь от стрел, наношу удар Ворону", "Спускаю клетку и помогаю ему освободится.", "Убиваю сначала слуг, а затем приступаю к графине.",
            "Тактика бей и беги никогда меня не подводила.", "За один раз ее не победить, нужно использовать порталы для восстановления ресурсов"));
    private final List<String> negativeAnswer = new ArrayList<>(List.of("Сохраню зелье лечения на потом, еще пригодится.",
            "Укроюсь за щитом и подожду пока у нее закончатся стрелы", "Я уверен, что справлюсь без помощи Кейна. Убегаю.",
            "Какой большой сундук, думаю в нем есть полезные припасы, которые помогут мне победить.", "Он не выглядит таким уж сильным, да и я уже подрос в умениях",
            "Она отвлеклась на напарницу, это мой шанс убить ее."));
    private final List<String> loseQuest = new ArrayList<>(List.of("Вы решили сохранить зелье и свои вещи для другого искателя приключений.",
            "К сожалению вы не знали, что у врагов в этой игре бесконечный запас стрел.", "Вас выгнали из лагеря узнав о произошедшем.",
            "В сундуке лежали только деньги. Вы ожидали увидеть что-то другое у графини?",
            "Он так сильно ударил молотом, что вы потеряли сознание. Очнутся не получилось.", "Без напарницы у вас не хватило ресурсов победить Андариель. Очень жаль."));
}