package org.jruby.truffle.translator;

import org.jruby.truffle.nodes.RubyNode;
import org.jruby.truffle.runtime.RubyContext;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.source.SourceSection;

public class MarkerNode extends RubyNode {
	
	private static Object markerInstance = new Object();
	
	public static Object getMarker() {
		return markerInstance;
	}
	
    public MarkerNode(RubyContext context, SourceSection sourceSection) {
        super(context, sourceSection);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return markerInstance;
    }
    
}
