package io.jenkins.plugins.better_pipeline_flowgraph_table;

import hudson.Extension;
import hudson.model.BallColor;
import org.jenkinsci.plugins.workflow.graph.FlowNode;
import org.jenkinsci.plugins.workflow.visualization.table.FlowNodeViewColumn;
import org.jenkinsci.plugins.workflow.visualization.table.FlowNodeViewColumnDescriptor;

public class StatusFormatterColumn extends FlowNodeViewColumn {
    @Extension
    public static class DescriptorImpl extends FlowNodeViewColumnDescriptor {
        @Override
        public FlowNodeViewColumn getDefaultInstance() {
            return new StatusFormatterColumn();
        }

        // Jelly
        public String getCssClass(FlowNode node) {
            if (node.getIconColor().equals(BallColor.BLUE)) {
                return "better-flowgraph-light";
            }
            if (node.getIconColor().equals(BallColor.YELLOW)) {
                return "better-flowgraph-warning";
            }
            if (node.getIconColor().equals(BallColor.RED)) {
                return "better-flowgraph-danger";
            }
            return "";
        }
    }
}
