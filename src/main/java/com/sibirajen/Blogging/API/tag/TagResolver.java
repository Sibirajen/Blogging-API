package com.sibirajen.Blogging.API.tag;

import com.sibirajen.Blogging.API.model.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TagResolver {
    public static List<Tag> toTagList(List<String> tags, TagRepository tagRepo){
        if (tags == null) return List.of();
        return tags.stream()
                .map(name -> {
                    String normalized = name.trim().toLowerCase();
                    return tagRepo.findByName(normalized)
                            .orElseGet(() -> tagRepo.save(new Tag(normalized)));
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static List<String> toStrList(List<Tag> tags){
        if (tags == null) return List.of();
        return tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
