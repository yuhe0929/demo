package compare;

import com.alibaba.fastjson.JSON;
import compare.model.AreaServiceModel;
import org.junit.Test;

import java.util.Objects;

public class CompareTest {

    @Test
    public void test() {
        AreaServiceModel model1 = JSON.parseObject(json, AreaServiceModel.class);
        AreaServiceModel model2 = JSON.parseObject(json, AreaServiceModel.class);
        model2.setAreaCode("");

        System.out.println("equals:" + model1.equals(model2));
        System.out.println("deepEquals:" + Objects.deepEquals(model1, model2));

    }

    private final String json = "{\n" +
            "            \"areacode\": \"RU\",\n" +
            "            \"areaType\": 0,\n" +
            "            \"areaName\": \"俄罗斯\",\n" +
            "            \"imageUrl\": \"https://dimg08.c-ctrip.com/images//100h0a0000004xz4b08EF_R_170_140.jpg\",\n" +
            "            \"cities\": [\n" +
            "                {\n" +
            "                    \"cityCode\": \"MOW\",\n" +
            "                    \"latitude\": 55.65555556,\n" +
            "                    \"longitude\": 37.52222222,\n" +
            "                    \"cityImg\": \"https://dimg08.c-ctrip.com/images//100h0a0000004xz4b08EF_R_200_170.jpg\",\n" +
            "                    \"holidayInfoList\": [],\n" +
            "                    \"scenicInfoList\": [\n" +
            "                        {\n" +
            "                            \"scenicId\": 81791,\n" +
            "                            \"scenicName\": \"红场\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 81792,\n" +
            "                            \"scenicName\": \"克里姆林宫\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 81799,\n" +
            "                            \"scenicName\": \"圣瓦西里升天大教堂\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 10559058,\n" +
            "                            \"scenicName\": \"莫斯科大学\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 10758317,\n" +
            "                            \"scenicName\": \"莫斯科河\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 84943,\n" +
            "                            \"scenicName\": \"国家历史博物馆\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 10559053,\n" +
            "                            \"scenicName\": \"麻雀山\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 10558881,\n" +
            "                            \"scenicName\": \"胜利广场\"\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"scenicId\": 84940,\n" +
            "                            \"scenicName\": \"基督救世主大教堂\"\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"topicModelList\": [],\n" +
            "                    \"cityName\": \"莫斯科\"\n" +
            "                }\n" +
            "        ]\n" +
            "}";
}
