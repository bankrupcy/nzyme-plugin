package app.nzyme.plugin.distributed.tasksqueue;

import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

@AutoValue
public abstract class StoredTask {

    public abstract Long id();
    public abstract UUID sender();
    public abstract TaskType type();
    public abstract Boolean allowRetry();
    public abstract Map<String, Object> parameters();
    public abstract DateTime createdAt();
    public abstract TaskStatus status();
    public abstract Integer retries();
    public abstract boolean allowProcessSelf();

    @Nullable
    public abstract TaskStatus previousStatus();

    @Nullable
    public abstract Integer processingTimeMs();

    @Nullable
    public abstract DateTime firstProcessedAt();

    @Nullable
    public abstract DateTime lastProcessedAt();

    @Nullable
    public abstract UUID processedBy();

    public static StoredTask create(Long id, UUID sender, TaskType type, Boolean allowRetry, Map<String, Object> parameters, DateTime createdAt, TaskStatus status, Integer retries, boolean allowProcessSelf, TaskStatus previousStatus, Integer processingTimeMs, DateTime firstProcessedAt, DateTime lastProcessedAt, UUID processedBy) {
        return builder()
                .id(id)
                .sender(sender)
                .type(type)
                .allowRetry(allowRetry)
                .parameters(parameters)
                .createdAt(createdAt)
                .status(status)
                .retries(retries)
                .allowProcessSelf(allowProcessSelf)
                .previousStatus(previousStatus)
                .processingTimeMs(processingTimeMs)
                .firstProcessedAt(firstProcessedAt)
                .lastProcessedAt(lastProcessedAt)
                .processedBy(processedBy)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_StoredTask.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Long id);

        public abstract Builder sender(UUID sender);

        public abstract Builder type(TaskType type);

        public abstract Builder allowRetry(Boolean allowRetry);

        public abstract Builder parameters(Map<String, Object> parameters);

        public abstract Builder createdAt(DateTime createdAt);

        public abstract Builder status(TaskStatus status);

        public abstract Builder retries(Integer retries);

        public abstract Builder allowProcessSelf(boolean allowProcessSelf);

        public abstract Builder previousStatus(TaskStatus previousStatus);

        public abstract Builder processingTimeMs(Integer processingTimeMs);

        public abstract Builder firstProcessedAt(DateTime firstProcessedAt);

        public abstract Builder lastProcessedAt(DateTime lastProcessedAt);

        public abstract Builder processedBy(UUID processedBy);

        public abstract StoredTask build();
    }
}
