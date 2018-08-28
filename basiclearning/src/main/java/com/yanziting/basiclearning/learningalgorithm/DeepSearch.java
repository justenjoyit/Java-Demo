package com.yanziting.basiclearning.learningalgorithm;

import com.google.common.collect.Lists;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author : Ziting.Yan
 * @since : 2018-08-15-11-39
 **/
@Component("deepSearch")
public class DeepSearch {

    public void mainDeepSearch() {
        Item item = Item.builder()
            .id("1")
            .name("1")
            .itemList(Lists.newArrayList(
                Item.builder()
                    .id("2")
                    .name("2")
                    .itemList(Lists.newArrayList(
                        Item.builder()
                            .id("5")
                            .name("5")
                            .build(),
                        Item.builder()
                            .id("6")
                            .name("6")
                            .itemList(Lists.newArrayList(
                                Item.builder()
                                    .id("9")
                                    .name("9")
                                    .build(),
                                Item.builder()
                                    .id("10")
                                    .name("10")
                                    .build()
                            ))
                            .build()
                    ))
                    .build(),
                Item.builder()
                    .id("3")
                    .name("3")
                    .build(),
                Item.builder()
                    .id("4")
                    .name("4")
                    .itemList(Lists.newArrayList(
                        Item.builder()
                            .id("7")
                            .name("7")
                            .build(),
                        Item.builder()
                            .id("8")
                            .name("8")
                            .build()
                    ))
                    .build()
            ))
            .build();

        List<String> nameList = Lists.newArrayList();
        deepSearch(item, nameList);

        for (String str : nameList) {
            System.out.println(str);
        }

    }

    private void deepSearch(Item item, List<String> nameList) {
        if (null == item) {
            return;
        }

        nameList.add(item.getName());

        if (item.getItemList() != null && !item.getItemList().isEmpty()) {
            for (Item item1 : item.getItemList()) {
                deepSearch(item1, nameList);
            }
        }
    }
}

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
class Item {

    private String id;
    private String name;
    private List<Item> itemList;

}