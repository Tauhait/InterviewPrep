package Amazon;

import java.util.ArrayList;
import java.util.List;

//I have my amazon interview coming up for SDE in seattle. One of my friends recently went on-site in Seattle and was asked this question in OOD. I have not been able to find a good approach to this question. Any suggestions would be helpful
//
//implemnet linux find command as an api ,the api willl support finding files that has given size requirements and a file with a certain format like
//
//find all file >5mb
//find all xml
//Assume file class
//{
//get name()
//directorylistfile()
//getFile()
//create a library flexible that is flexible
//Design clases,interfaces.

//could we use interface rather than abstract class here? yes, and you should.
//Interface and Abstract class are semantically different. Interfaces communicate behavior without providing any implementation (no longer true since Java8 but there is still a certain degree of truth in this). 
//Abstract classes are most commonly subclassed to share pieces of implementation If I see an abstract class. If I see an abstract class, I assume that there is some implementation in it. Even when I just scroll file tree in the IDE, if I see a class I know there should be implementation in it, if I see an interface I know there is no implementation. When you look at the code and try to understand how it works it helps starting from the interfaces. Adding an abstract class with no implementation is confusing.
//From a practical standpoint interfaces allow multiple-inheritance while abstract classes don't.
//Two possible followup questions:
//
//How do you handle boolean logic (the current solution put all the filters in OR)
//class NotFilter extends Filter {
//
//    Filter filter;
//    
//    NotFilter(Filter filter) {
//        this.filter = filter;
//    }
//
//    @Override
//    boolean apply(File file) {
//        return !filter.apply(file);
//    }
//}
//
//class OrFilter extends Filter {
//
//    List<Filter> filters;
//
//    OrFilter(List<Filter> filters) {
//        this.filters = filters;
//    }
//
//    @Override
//    boolean apply(File file) {
//        boolean selectFile = false;
//        for (Filter filter : filters) {
//            if (filter.apply(file)) {
//                selectFile = true;
//            }
//        }
//        return selectFile;
//    }
//
//}
//
//class AndFilter extends Filter {
//
//    List<Filter> filters;
//
//    AndFilter(List<Filter> filters) {
//        this.filters = filters;
//    }
//
//    @Override
//    boolean apply(File file) {
//        for (Filter filter : filters) {
//            if (!filter.apply(file)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
//How do you handle an output that would not fit in memory
//There are many possible approaches to handle a huge number of files. A couple of them:
//
//Instead of returning a List, pass in an handler, eg:
//interface FileSearchHandler {
//    public void onFileFound(File f);
//}
//You are now moving the responsibility of handling the output the the user of the library.
//
//Instead of returning a List, you can pass in a BlockingQueue
//Here again you are moving the responsibility of handling the output to the user. The user will initialize the Queue with a size he/she know can handle. The user is supposed to consume the queue. If the queue get full, the file search will lock waiting for the queue to be consumed.

public class UnixFindCmdAPI {
	class File {
	    String name;
	    int size;
	    int type;
	    boolean isDirectory;
	    File[] children;
	}

	abstract class Filter {
	    abstract boolean apply(File file);
	}

	class MinSizeFilter extends Filter {

	    int minSize;

	    public MinSizeFilter(int minSize) {
	        this.minSize = minSize;
	    }

	    @Override
	    boolean apply(File file) {
	        return file.size > minSize;
	    }
	}

	class TypeFilter extends Filter {

	    int type;

	    public TypeFilter(int type) {
	        this.type = type;
	    }

	    @Override
	    boolean apply(File file) {
	        return file.type == type;
	    }
	}

	class FindCommand {

	    public List<File> findWithFilters(File directory, List<Filter> filters) {
	        if (!directory.isDirectory) {
	            return null;
	        }
	        List<File> output = new ArrayList<>();
	        findWithFilters(directory, filters, output);
	        return output;
	    }

	    private void findWithFilters(File directory, List<Filter> filters, List<File> output) {
	        if (directory.children == null) {
	            return;
	        }
	        for (File file : directory.children) {
	            if (file.isDirectory) {
	                findWithFilters(file, filters, output);
	            } else {
	                boolean selectFile = true;
	                for (Filter filter : filters) {
	                    if (!filter.apply(file)) {
	                        selectFile = false;
	                    }
	                }
	                if (selectFile) {
	                    output.add(file);
	                }
	            }
	        }
	    }
	}

}
