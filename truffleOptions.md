# Truffle Options
### You can list options from the command line with any language launcher:

##  Default Language Launcher Options
- `--vm.[option]` : Pass options to the host VM. To see available options, use `--help:vm`.
- `--log.file=<String>` : Redirect guest languages logging into a given file.
- `--log.[logger].level=<String>` : Set language log level to OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST or ALL.
- `--help` : Print this help message.
- `--help:vm` : Print options for the host VM.
- `--version:graalvm` : Print GraalVM version information and exit.
- `--show-version:graalvm` : Print GraalVM version information and continue execution.
- `--help:languages` : Print options for all installed languages.
- `--help:tools` : Print options for all installed tools.
- `--help:expert` : Print additional options for experts.
- `--help:internal` : Print internal options for debugging language implementations and tools.

## Internal Engine Options
### These are internal options for debugging language implementations and tools.

- `-Dpolyglot.engine.SpecializationStatistics` : Enables specialization statistics for nodes generated with Truffle DSL and prints the result on exit. In order for this flag to be functional -Atruffle.dsl.GenerateSpecializationStatistics=true needs to be set at build time. Enabling this flag and the compiler option has major implications on the performance and footprint of the interpreter. Do not use in production environments.
- `-Dpolyglot.engine.CompilationStatisticDetails` : Print additional more verbose Truffle compilation statistics at the end of a run.
- `-Dpolyglot.engine.CompilationStatistics` : Print Truffle compilation statistics at the end of a run.
- `-Dpolyglot.engine.CompileImmediately` : Compile immediately to test Truffle compilation
- `-Dpolyglot.engine.CompileOnly=<name>,<name>,...` : Restrict compilation to ','-separated list of includes (or excludes prefixed with '~'). No restriction by default.
- `-Dpolyglot.engine.Profiling=true|false` : Enable/disable builtin profiles in com.oracle.truffle.api.profiles. (default: true)
- `-Dpolyglot.engine.ReturnTypeSpeculation=true|false` : Speculate on return types at call sites (default: true)
- `-Dpolyglot.engine.TraceAssumptions` : Print stack trace on assumption invalidation
- `-Dpolyglot.engine.TraceCompilationAST` : Print the entire AST after each compilation
- `-Dpolyglot.engine.TraceCompilationDetails` : Print information for compilation queuing.
- `-Dpolyglot.engine.TraceCompilationPolymorphism` : Print all polymorphic and generic nodes after each compilation
- `-Dpolyglot.engine.TraceDeoptimizeFrame` : Print stack trace when deoptimizing a frame from the stack with `FrameInstance#getFrame(READ_WRITE|MATERIALIZE)`.
- `-Dpolyglot.engine.InlineOnly` : Restrict inlined methods to ','-separated list of includes (or excludes prefixed with '~'). No restriction by default. (usage: <name>,<name>,...)
- `-Dpolyglot.engine.InliningPolicy` : Explicitly pick a inlining policy by name. If empty (default) the highest priority chosen by default.
- `-Dpolyglot.engine.InliningUseSize` : Use the graph size as a cost model during inlining (default: false).
- `-Dpolyglot.engine.InstrumentBoundaries` : Instrument Truffle boundaries and output profiling information to the standard output.
- `-Dpolyglot.engine.InstrumentBoundariesPerInlineSite` : Instrument Truffle boundaries by considering different inlining sites as different branches.
- `-Dpolyglot.engine.InstrumentBranches` : Instrument branches and output profiling information to the standard output.
- `-Dpolyglot.engine.InstrumentBranchesPerInlineSite` : Instrument branches by considering different inlining sites as different branches.
- `-Dpolyglot.engine.InstrumentFilter` : Method filter for host methods in which to add instrumentation (syntax: <method>,<method>,....)
- `-Dpolyglot.engine.InstrumentationTableSize` : Maximum number of instrumentation counters available (default: 10000, syntax: [1, inf))
- `-Dpolyglot.engine.IterativePartialEscape` : Run the partial escape analysis iteratively in Truffle compilation.
- `-Dpolyglot.engine.LogInlinedTargets` : Logs inlined targets for statistical purposes (default: false).
- `-Dpolyglot.engine.FirstTierInliningPolicy` : Explicitly pick a first tier inlining policy by name (None, TrivialOnly). If empty (default) the lowest priority policy (TrivialOnly) is chosen.
- `-Dpolyglot.engine.InlineAcrossTruffleBoundary` : Enable inlining across Truffle boundary
- `-Dpolyglot.engine.MaximumGraalGraphSize` : Stop partial evaluation when the graph exceeded this size (default: 150000, syntax: [1, inf))
- `-Dpolyglot.engine.MethodExpansionStatistics` : Print statistics on expanded Java methods during partial evaluation at the end of a run.(syntax: true|false|peTier|truffleTier|lowTier|<tier>,<tier>,...)
  Accepted values are:
  true - Collect data for the default tier 'truffleTier'.
  false - No data will be collected.
  Or one or multiple tiers separated by comma (e.g. truffleTier,lowTier):
  peTier - After partial evaluation without additional phases applied.
  truffleTier - After partial evaluation with additional phases applied.
  lowTier - After low tier phases were applied.
- `-Dpolyglot.engine.NodeExpansionStatistics` : Print statistics on expanded Truffle nodes during partial evaluation at the end of a run.(syntax: true|false|peTier|truffleTier|lowTier|<tier>,<tier>,...)
  Accepted values are:
  true - Collect data for the default tier 'truffleTier'.
  false - No data will be collected.
  Or one or multiple tiers separated by comma (e.g. truffleTier,lowTier):
  peTier - After partial evaluation without additional phases applied.
  truffleTier - After partial evaluation with additional phases applied.
  lowTier - After low tier phases were applied.
- `-Dpolyglot.engine.NodeSourcePositions` : Enable node source positions in truffle partial evaluations.
- `-Dpolyglot.engine.ParsePEGraphsWithAssumptions` : Allow assumptions during parsing of seed graphs for partial evaluation. Disables the persistent encoded graph cache 'engine.EncodedGraphCache'. (default: false).
- `-Dpolyglot.engine.TraceInlining` : Print information for inlining decisions.
- `-Dpolyglot.engine.TraceInliningDetails` : Print detailed information for inlining (i.e. the entire explored call tree).
- `-Dpolyglot.engine.TraceMethodExpansion` : Print a tree of all expanded Java methods with statistics after each compilation. (syntax: true|false|peTier|truffleTier|lowTier|<tier>,<tier>,...)
  Accepted values are:
  true - Collect data for the default tier 'truffleTier'.
  false - No data will be collected.
  Or one or multiple tiers separated by comma (e.g. truffleTier,lowTier):
  peTier - After partial evaluation without additional phases applied.
  truffleTier - After partial evaluation with additional phases applied.
  lowTier - After low tier phases were applied.
- `-Dpolyglot.engine.TraceNodeExpansion` : Print a tree of all expanded Truffle nodes with statistics after each compilation. (syntax: true|false|peTier|truffleTier|lowTier|<tier>,<tier>,...)
  Accepted values are:
  true - Collect data for the default tier 'truffleTier'.
  false - No data will be collected.
  Or one or multiple tiers separated by comma (e.g. truffleTier,lowTier):
  peTier - After partial evaluation without additional phases applied.
  truffleTier - After partial evaluation with additional phases applied.
  lowTier - After low tier phases were applied.


- `-Dpolyglot.engine.DisableCodeSharing` : Option to force disable code sharing for this engine, even if the context was created with an explicit engine. This option is intended for testing purposes only.
- `-Dpolyglot.engine.ForceCodeSharing` : Option to force enable code sharing for this engine, even if the context was created with a bound engine. This option is intended for testing purposes only.
- `-Dpolyglot.engine.TraceCodeSharing` : Enables printing of code sharing related information to the logger. This option is intended to support debugging language implementations.
- `-Dpolyglot.engine.InstrumentExceptionsAreThrown=true|false` : Propagates exceptions thrown by instruments. (default: true)
- `-Dpolyglot.engine.PrintInternalStackTrace` : Printed PolyglotException stacktrace unconditionally contains the stacktrace of the original internal exception as well as the stacktrace of the creation of the PolyglotException instance.
- `-Dpolyglot.engine.SafepointALot` : Repeadly submits thread local actions and collects statistics about safepoint intervals in the process. Prints event and interval statistics when the context is closed for each thread. This option significantly slows down execution and is therefore intended for testing purposes only.
- `-Dpolyglot.engine.ShowInternalStackFrames` : Show internal frames specific to the language implementation in stack traces.
- `-Dpolyglot.engine.StaticObjectStorageStrategy=default|array-based|field-based` : Set the storage strategy used by the Static Object Model. Accepted values are: ['default', 'array-based', 'field-based']
- `-Dpolyglot.engine.TriggerUncaughtExceptionHandlerForCancel` : Propagates cancel execution exception into UncaughtExceptionHandler. For testing purposes only.
- `-Dpolyglot.engine.UseConservativeContextReferences` : Enables conservative context references. This allows invalid sharing between contexts. For testing purposes only.
- `-Dpolyglot.engine.UsePreInitializedContext=true|false` : Use pre-initialized context when it's available (default: true).
- `-Dpolyglot.engine.DebugCacheCompile=none|compiled|hot|aot|executed` : Policy to use to to force compilation for executed call targets before persisting the engine. Possible values are:
  - 'none':     No compilations will be persisted and existing compilations will be invalidated.
  - 'compiled': No compilations will be forced but finished compilations will be persisted.
  - 'hot':      (default) All started compilations will be completed and then persisted.
  - 'aot':      All started and AOT compilable roots will be forced to compile and persisted.
  - 'executed': All executed and all AOT compilable roots will be forced to compile.
- `-Dpolyglot.engine.ArgumentTypeSpeculation=true|false` : Speculate on arguments types at call sites (default: true)
- `-Dpolyglot.engine.CompileAOTOnCreate` : Compiles created call targets immediately with last tier. Disables background compilation if enabled.
- `-Dpolyglot.engine.DynamicCompilationThresholds=true|false` : Reduce or increase the compilation threshold depending on the size of the compilation queue (default: true).
- `-Dpolyglot.engine.DynamicCompilationThresholdsMaxNormalLoad=[1, inf)` : The desired maximum compilation queue load. When the load rises above this value, the compilation thresholds are increased. The load is scaled by the number of compiler threads.  (default: 10)
- `-Dpolyglot.engine.DynamicCompilationThresholdsMinNormalLoad=[1, inf)` : The desired minimum compilation queue load. When the load falls bellow this value, the compilation thresholds are decreased. The load is scaled by the number of compiler threads (default: 10).
- `-Dpolyglot.engine.DynamicCompilationThresholdsMinScale=[0.0, inf)` : The minimal scale the compilation thresholds can be reduced to (default: 0.1).
- `-Dpolyglot.engine.OSRCompilationThreshold=[1, inf)` : Number of loop iterations until on-stack-replacement compilation is triggered (default 100352).
- `-Dpolyglot.engine.OSRMaxCompilationReAttempts=[0, inf)` : Number of compilation re-attempts before bailing out of OSR compilation for a given method (default 30). This number is an approximation of the acceptable number of deopts.
- `-Dpolyglot.engine.PriorityQueue=true|false` : Use the priority of compilation jobs in the compilation queue (default: true).
- `-Dpolyglot.engine.PropagateLoopCountToLexicalSingleCaller=true|false` : Enables hotness propagation to lexical parent to lexically parent single callers.
- `-Dpolyglot.engine.PropagateLoopCountToLexicalSingleCallerMaxDepth=[0, inf)` : How high to propagate call and loop count (hotness proxy) up a single caller chain to lexical scope parent.
- `-Dpolyglot.engine.SplittingAllowForcedSplits=true|false` : Should forced splits be allowed (default: true)
- `-Dpolyglot.engine.SplittingDumpDecisions` : Dumps to IGV information on polymorphic events
- `-Dpolyglot.engine.SplittingGrowthLimit=[0.0, inf)` : Disable call target splitting if the number of nodes created by splitting exceeds this factor times node count (default: 1.5).
- `-Dpolyglot.engine.SplittingMaxCalleeSize=[1, inf)` : Disable call target splitting if tree size exceeds this limit (default: 100)
- `-Dpolyglot.engine.SplittingMaxPropagationDepth=[1, inf)` : Propagate info about a polymorphic specialize through maximum this many call targets (default: 5)
- `-Dpolyglot.engine.SplittingTraceEvents` : Trace details of splitting events and decisions.
- `-Dpolyglot.engine.ThrowOnMaxOSRCompilationReAttemptsReached=true|false` : Whether an AssertionError is thrown when the maximum number of OSR compilation attempts is reached for a given method (default 'false'). This should only be set to 'true' in testing environments.
- `-Dpolyglot.engine.TraceSplitting` : Print information for splitting decisions.
- `-Dpolyglot.engine.TraceSplittingSummary` : Used for debugging the splitting implementation. Prints splitting summary directly to stdout on shutdown
- `-Dpolyglot.engine.TraceStackTraceLimit=[1, inf)` : Number of stack trace elements printed by TraceTruffleTransferToInterpreter, TraceTruffleAssumptions and TraceDeoptimizeFrame (default: 20).
- `-Dpolyglot.engine.TraceTransferToInterpreter` : Print stack trace on transfer to interpreter.
- `-Dpolyglot.engine.TraversingCompilationQueue=true|false` : Use a traversing compilation queue. (default: true)
- `-Dpolyglot.engine.TraversingQueueFirstTierBonus=[0.0, inf)` : Controls how much of a priority should be given to first tier compilations (default 15.0).
- `-Dpolyglot.engine.TraversingQueueFirstTierPriority` : Traversing queue gives first tier compilations priority.
- `-Dpolyglot.engine.TraversingQueueWeightingBothTiers=true|false` : Traversing queue uses rate as priority for both tier. (default: true)
- `-Dpolyglot.engine.DiagnoseFailure` : Forces diagnostics for compilation failures (default: false).
- `-Dpolyglot.engine.ExcludeAssertions` : Exclude assertion code from Truffle compilations (default: true)
- `-Dpolyglot.engine.TracePerformanceWarnings` : Print potential performance problems, Performance warnings are: call, instanceof, store, frame_merge, trivial. (syntax: none|all|<perfWarning>,<perfWarning>,...)
- `-Dpolyglot.engine.TraceStackTraceLimit` : Number of stack trace elements printed by TraceTruffleTransferToInterpreter, TraceTruffleAssumptions and TraceDeoptimizeFrame (default: 20). Syntax: [1, inf).
- `-Dpolyglot.engine.TreatPerformanceWarningsAsErrors` : Treat performance warnings as error. Handling of the error depends on the CompilationFailureAction option value. Performance warnings are: call, instanceof, store, frame_merge, trivial. (syntax: none|all|<perfWarning>,<perfWarning>,...)
- `-Dpolyglot.engine.IsolateLibrary=<path>` : Path to the isolate library.

## Expert Engine Options
### These are advanced options for controlling the engine. They are useful to users and language and tool implementers.
- `-Dpolyglot.engine.Compilation=true|false` : Enable or disable Truffle compilation.
- `-Dpolyglot.engine.CompilationFailureAction=Silent|Print|Throw|Diagnose|ExitVM` : Specifies the action to take when Truffle compilation fails.
  The accepted values are:
  Silent - Print nothing to the console.
  Print - Print the exception to the console.
  Throw - Throw the exception to caller.
  Diagnose - Retry compilation with extra diagnostics enabled.
  ExitVM - Exit the VM process.
- `-Dpolyglot.engine.CompilerThreads=[1, inf)` : Manually set the number of compiler threads. By default, the number of compiler threads is scaled with the number of available cores on the CPU.
- `-Dpolyglot.engine.Mode=latency|throughput` : Configures the execution mode of the engine. Available modes are 'latency' and 'throughput'. The default value balances between the two.
- `-Dpolyglot.engine.MultiTier=true|false` : Whether to use multiple Truffle compilation tiers by default. (default: true)
- `-Dpolyglot.engine.OSR=true|false` : Enable automatic on-stack-replacement of loops (default: true).
- `-Dpolyglot.engine.TraceCompilation` : Print information for compilation results.
- `-Dpolyglot.engine.FirstTierUseEconomy` : Whether to use the economy configuration in the first-tier compilations. (default: true, syntax: true|false)
- `-Dpolyglot.engine.Inlining` : Enable automatic inlining of guest language call targets (default: true, usage: true|false).


- `-Dpolyglot.engine.FirstTierBackedgeCounts=true|false` : Whether to emit look-back-edge counters in the first-tier compilations. (default: true)
- `-Dpolyglot.engine.FirstTierCompilationThreshold=[1, inf)` : Number of invocations or loop iterations needed to compile a guest language root in first tier under normal compilation load.Might be reduced/increased when compilation load is low/high if DynamicCompilationThresholds is enabled. (default: 400).
- `-Dpolyglot.engine.FirstTierMinInvokeThreshold=[1, inf)` : Minimum number of calls before a call target is compiled in the first tier (default: 1)
- `-Dpolyglot.engine.LastTierCompilationThreshold=[1, inf)` : Number of invocations or loop iterations needed to compile a guest language root in first tier under normal compilation load.Might be reduced/increased when compilation load is low/high if DynamicCompilationThresholds is enabled. (default: 10000).
- `-Dpolyglot.engine.PreinitializeContexts` : Pre initialize language contexts for given languages.
- `-Dpolyglot.engine.RelaxStaticObjectSafetyChecks` : On property accesses, the Static Object Model does not perform shape checks and uses unsafe casts
- `-Dpolyglot.engine.TraceStackTraceInterval=[1, inf)` : Prints the stack trace for all threads for a time interval. By default 0, which disables the output.
- `-Dpolyglot.engine.DebugCacheCompileUseLastTier=true|false` : If true uses the last tier instead of the first tier compiler. By default the last tier compiler is used (default: true).
- `-Dpolyglot.engine.BackgroundCompilation=true|false` : Enable asynchronous truffle compilation in background threads (default: true)
- `-Dpolyglot.engine.CompilerIdleDelay=<ms>` : Set the time in milliseconds an idle Truffle compiler thread will wait for new tasks before terminating. New compiler threads will be started once new compilation tasks are submitted. Select '0' to never terminate the Truffle compiler thread. The option is not supported by all Truffle runtimes. On the runtime which doesn't support it the option has no effect. default: 10000
- `-Dpolyglot.engine.EncodedGraphCachePurgeDelay=<ms>` : Delay, in milliseconds, after which the encoded graph cache is dropped when a Truffle compiler thread becomes idle (default: 10000).
- `-Dpolyglot.engine.MinInvokeThreshold=[1, inf)` : Minimum number of calls before a call target is compiled (default: 3).
- `-Dpolyglot.engine.PartialBlockCompilation=true|false` : Enable partial compilation for BlockNode (default: true).
- `-Dpolyglot.engine.PartialBlockCompilationSize=[1, inf)` : Sets the target non-trivial Truffle node size for partial compilation of BlockNode nodes (default: 3000).
- `-Dpolyglot.engine.PartialBlockMaximumSize=[1, inf)` : Sets the maximum non-trivial Truffle node size for partial compilation of BlockNode nodes (default: 10000).
- `-Dpolyglot.engine.SingleTierCompilationThreshold=[1, inf)` : Minimum number of invocations or loop iterations needed to compile a guest language root when not using multi tier (default: 1000).
- `-Dpolyglot.engine.Splitting=true|false` : Enable automatic duplication of compilation profiles (splitting) (default: true).
- `-Dpolyglot.engine.EncodedGraphCache` : Cache encoded graphs across Truffle compilations to speed up partial evaluation. (default: true).
- `-Dpolyglot.engine.InliningExpansionBudget` : The base expansion budget for language-agnostic inlining (default: 12000). Syntax: [1, inf)
- `-Dpolyglot.engine.InliningInliningBudget` : The base inlining budget for language-agnostic inlining (default: 12000). Syntax: [1, inf)
- `-Dpolyglot.engine.InliningRecursionDepth` : Maximum depth for recursive inlining (default: 2, usage: [0, inf)).
- `-Dpolyglot.engine.HostCallStackHeadRoom=[1, inf)<B>|<KB>|<MB>|<GB>` : Stack space headroom for calls to the host.
- `-Dpolyglot.engine.IsolateMemoryProtection=true|false` : Enable memory protection for the isolate.
- `-Dpolyglot.engine.IsolateOption.<key>=<value>` : Isolate VM options.
