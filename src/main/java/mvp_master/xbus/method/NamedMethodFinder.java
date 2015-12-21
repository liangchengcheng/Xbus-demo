package mvp_master.xbus.method;

import java.util.Set;
import mvp_master.xbus.Bus;
import mvp_master.xbus.MethodInfo;

/**
 * Author:  梁铖城
 * Email:   1038127753@qq.com
 * Date:
 * Description:
 */
public class NamedMethodFinder implements MethodFinder {
    public static final String DEFAULT_NAME = "onEvent";

    private final String name;

    public NamedMethodFinder() {
        this(DEFAULT_NAME);
    }

    public NamedMethodFinder(final String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("invalid method name");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Set<MethodInfo> find(final Bus bus, final Class<?> targetClass) {
        return MethodHelper.findSubscriberMethodsByName(targetClass, name);
    }
}
