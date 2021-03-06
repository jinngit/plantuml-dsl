package com.makasprzak.plantuml.dsl.activity.levels.impl;

import com.makasprzak.plantuml.dsl.activity.ActivityBuilderBase;
import com.makasprzak.plantuml.dsl.activity.levels.ConditionLevel;
import com.makasprzak.plantuml.dsl.activity.levels.WhenFalseFurtherLevel;
import com.makasprzak.plantuml.dsl.activity.ActivityGraphBuilder;

public class WhenFalseFurtherLevelBuilder<T extends ActivityBuilderBase> implements WhenFalseFurtherLevel<T> {
    private final ActivityGraphBuilder activityGraphBuilder;
    private final T previousLevel;

    public WhenFalseFurtherLevelBuilder(ActivityGraphBuilder activityGraphBuilder, T previousLevel) {
        this.activityGraphBuilder = activityGraphBuilder;
        this.previousLevel = previousLevel;
    }

    @Override
    public WhenFalseFurtherLevel<T> activity(String label) {
        activityGraphBuilder.whenFalseFurtherLevelActivity(label);
        return this;
    }

    @Override
    public ConditionLevel<WhenFalseFurtherLevel<T>> condition(String label) {
        activityGraphBuilder.whenFalseFurtherLevelCondition(label);
        return conditionLevel();
    }

    @Override
    public WhenFalseFurtherLevel<T> end() {
        activityGraphBuilder.whenFalseFurtherLevelEnd();
        return this;
    }

    @Override
    public T endIf() {
        activityGraphBuilder.whenFalseFurtherLevelEndIf();
        return previousLevel;
    }

    private ConditionLevelBuilder<WhenFalseFurtherLevel<T>> conditionLevel() {
        return new ConditionLevelBuilder<WhenFalseFurtherLevel<T>>(activityGraphBuilder, this);
    }
}
