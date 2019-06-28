package ru.job4j.departments;

import java.util.*;

public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            int result = -1;
            if (this.deps.equals(o.deps)) {
                result = 0;
            }
            return result;
        }

        @Override
        public String toString() {
            return "Org{" +
                    "deps=" + deps +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Org org = (Org) o;
            return Objects.equals(deps, org.deps);
        }

        @Override
        public int hashCode() {
            return Objects.hash(deps);
        }
    }

    public List<Org> convert(List<String> deps) {
        List<Org> result = new ArrayList<>();
        for (String curentDep : deps) {
            List<String> items = Arrays.asList(curentDep.split("/"));
            for (int i = 0; i < items.size(); i++) {
                List<String> itemsNew = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    itemsNew.add(items.get(j));
                }
                result.add(new Org(itemsNew));
            }
        }
        return result;
    }

    public List<Org> sortAsc(List<Org> orgs) {
        return orgs;
    }

    public List<Org> sortDesc(List<Org> orgs) {
        orgs.sort(new Comparator<Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                int result = 0;
                result = o1.deps.size() - o2.deps.size();
                if (result == 0) {
                    result = o2.compareTo(o1);
                }
                return result;
            }
        });
        return orgs;
    }
}