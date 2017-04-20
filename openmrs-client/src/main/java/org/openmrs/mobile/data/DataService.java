package org.openmrs.mobile.data;

import org.openmrs.mobile.models.BaseOpenmrsObject;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Represents classes that provide data services for {@link BaseOpenmrsObject} objects.
 * @param <E> The entity class
 */
public interface DataService<E extends BaseOpenmrsObject> {
    /**
     * Callback interface for operations with no return value.
     */
    interface VoidCallback {
        /**
         * Called if the operation completes successfully.
         */
        void onCompleted();

        /**
         * Called if the operation fails.
         * @param t The exception information
         */
        void onError(Throwable t);
    }

    /**
     * Callback interface for data service methods
     * @param <TResult> The result of the function execution
     */
    interface GetCallback<TResult> {
        /**
         * Called if the operation completes successfully.
         * @param result The returned result
         */
        void onCompleted(TResult result);

        /**
         * Called if the operations fails.
         * @param t The exception information
         */
        void onError(Throwable t);
    }

    /**
     * Gets a single entity with the specified UUID.
     * @param uuid The entity UUID
     * @param callback
     */
    void getByUUID(@NonNull String uuid, @NonNull GetCallback<E> callback);

    /**
     * Gets all entities.
     * @param includeInactive {@code true} to include inactive entities; otherwise, {@code false}
     * @param pagingInfo The paging information or null to exclude paging
     * @param callback
     */
    void getAll(boolean includeInactive, @Nullable PagingInfo pagingInfo,
                @NonNull GetCallback<List<E>> callback);

    /**
     * Performs a template-based search. Doesn't actually work at this point, unless you search
     * for something which should return no results.
     * @param template The entity template to create the search values from
     * @param pagingInfo The paging information or null to exclude paging
     * @param callback
     */
    void search(@NonNull E template, @Nullable PagingInfo pagingInfo,
                @NonNull GetCallback<List<E>> callback);

    /**
     * Saves a newly created entity.
     * @param entity The new entity to save
     * @param callback
     */
    void create(@NonNull E entity, @NonNull GetCallback<E> callback);

    /**
     * Saves an updated entity.
     * @param entity The entity to save
     * @param callback
     */
    void update(@NonNull E entity, @NonNull GetCallback<E> callback);

    /**
     * Completely deletes the entity.
     * @param entity The entity to purge
     * @param callback
     */
    void purge(@NonNull E entity, @NonNull VoidCallback callback);
}

